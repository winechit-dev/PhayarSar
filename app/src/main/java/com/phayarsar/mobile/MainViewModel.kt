package com.phayarsar.mobile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.phayarsar.localization.LocalizationRepository
import com.phayarsar.localization.model.LocalizationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    localizationRepository: LocalizationRepository
) : ViewModel() {

    val localizationFlow :StateFlow<LocalizationModel> = localizationRepository.localizationFlow.stateIn(
        scope = viewModelScope,
        initialValue = LocalizationModel(),
        started = SharingStarted.WhileSubscribed(5_000)
    )
}