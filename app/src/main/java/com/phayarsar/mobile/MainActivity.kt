package com.phayarsar.mobile

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.core.os.LocaleListCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.phayarsar.design_system.theme.PysTheme
import com.phayarsar.localization.model.LocalizationModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private var localization: LocalizationModel by mutableStateOf(LocalizationModel())
    private var screenState: ScreenState by mutableStateOf(ScreenState.SelectedLanguage)
    private var selectedLanguage by mutableStateOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        /*lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.localizationFlow.collectLatest {
                    localization = it
                }
            }
        }*/

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.screenStateFlow.collectLatest {
                    screenState = it
                }
            }
        }

        setContent {
            // collect screen state

            PysTheme {
                // Localization(localization) {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    getCurrentLocale()
                    NavigationController(
                        screenState = screenState // pass screen state
                    )
                }
                //  }
            }
        }
    }
}

fun getCurrentLocale(): String {
    /* return if (AppCompatDelegate.getApplicationLocales().isEmpty) {
         "en"
     } else {
         AppCompatDelegate.getApplicationLocales()[0]?.language?: "en"
     }*/
    val locale = AppCompatDelegate.getApplicationLocales()[0]?.language ?: "en"
    setCurrentLocale(locale)
    return locale
}

fun setCurrentLocale(locale: String) {
    AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(locale))
}

