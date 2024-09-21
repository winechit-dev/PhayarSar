package com.phyarsar.home.selectedLanguage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.phayarsar.domain.model.LanguageModel
import com.phayarsar.localization.LocalizationRepository
import com.phayarsar.localization.model.ENGLISH
import com.phayarsar.localization.model.MYANMAR
import com.phyarsar.home.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class SelectedLanguageViewModel @Inject constructor(
    private val localizationRepository: LocalizationRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(languageList)
    val uiState: StateFlow<List<LanguageModel>> = _uiState.asStateFlow()

    private var selectedLanguage = ""

   /* init {
        viewModelScope.launch {
            localizationRepository.localeFlow.collectLatest { locale ->
                _uiState.update {
                    it.map { languageModel ->
                        languageModel.copy(
                            isSelected = languageModel.language == locale.language
                        )
                    }
                }
            }
        }
    }*/

    fun selectLanguage(language: String) {
        selectedLanguage = language
        _uiState.update {
            it.map { languageModel ->
                languageModel.copy(
                    isSelected = languageModel.language == language
                )
            }
        }
    }

    fun changeLocale() {
        viewModelScope.launch(Dispatchers.IO) {
            if (selectedLanguage.isNotEmpty()) {
                localizationRepository.changeLocale(Locale(selectedLanguage))
            }
        }
    }
}

val languageList = listOf(
    LanguageModel(
        language = ENGLISH.language,
        title = "English",
        body = "(English)",
        image = R.drawable.ic_uk_flag,
        isSelected = true,
        locale = ENGLISH
    ),
    LanguageModel(
        language = MYANMAR.language,
        title = "Myanmar",
        body = "(မြန်မာစာ)",
        image = R.drawable.ic_myanmar_flag,
        isSelected = false,
        locale = MYANMAR
    )
)
