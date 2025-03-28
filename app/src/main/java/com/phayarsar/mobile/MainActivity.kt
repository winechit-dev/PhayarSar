package com.phayarsar.mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.phayarsar.design_system.theme.PysTheme
import com.phayarsar.localization.Localization
import com.phayarsar.localization.model.LocalizationModel
import com.phayarsar.mobile.navigation.NavigationController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()
    private var localization: LocalizationModel by mutableStateOf(LocalizationModel())
    private var screenState: ScreenState by mutableStateOf(ScreenState.SelectedLanguage)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()
        enableEdgeToEdge()

        splashScreen.setKeepOnScreenCondition {
            screenState.name == ScreenState.Splash.name
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.localizationFlow.collectLatest {
                    localization = it
                }
            }
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.screenStateFlow.collectLatest {
                    screenState = it
                }
            }
        }

        setContent {
            PysTheme {
                Localization(localization) {
                    NavigationController(
                        screenState = screenState
                    )
                }
            }
        }
    }
}

