package com.phayarsar.mobile.navigation

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.phayarsar.mobile.ScreenState
import com.phayarsar.setting.SettingScreen
import com.phyarsar.home.DetailScreenSample
import com.phyarsar.home.HomeEvent
import com.phyarsar.home.HomeScreen
import com.phyarsar.home.onboarding.SplashScreen
import com.phyarsar.home.onboarding.WelcomeScreen
import com.phyarsar.home.selectedLanguage.SelectLanguageScreen

@Composable
fun NavigationController(
    screenState: ScreenState
) {

    val navController = rememberNavController()
    val startRoute = remember(screenState) {
        when (screenState) {
            ScreenState.Splash -> ScreenRoute.Splash.route
            ScreenState.Home -> ScreenRoute.HomeScreen.route
            ScreenState.SelectedLanguage -> ScreenRoute.SelectLanguage.route
        }
    }

    Scaffold(
        contentWindowInsets = WindowInsets(0),
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomNavigation(navController = navController) }
    ) { innerPadding->

        NavHost(
            navController = navController,
            startDestination = startRoute,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(ScreenRoute.Splash.route) {
                SplashScreen()
            }

            composable(ScreenRoute.SelectLanguage.route) {
                SelectLanguageScreen(
                    onClickNext = {
                        navController.navigate("welcome")
                    }
                )
            }

            composable(ScreenRoute.WelcomeScreen.route) {
                WelcomeScreen(
                    onClickGetStarted = {
                        navController.navigate("home")
                    }
                )
            }

            composable(ScreenRoute.HomeScreen.route) {
                HomeScreen(
                    onClick = { homeEvent ->
                        when (homeEvent) {
                            is HomeEvent.GoToDetails -> {
                                navController.navigate("detail")
                            }

                            is HomeEvent.OnBack -> {
                                navController.navigateUp()
                            }
                        }
                    }
                )
            }

            composable(ScreenRoute.DetailScreen.route) {
                DetailScreenSample()
            }

            composable(ScreenRoute.SettingScreen.route) {
                SettingScreen()
            }
        }
    }
}

enum class ScreenRoute(val route: String) {
    Splash(route = "splash"),
    SelectLanguage(route = "selectLanguage"),
    WelcomeScreen(route = "welcome"),
    HomeScreen(route = "home"),
    DetailScreen(route = "detail"),
    SettingScreen(route = "setting")
}