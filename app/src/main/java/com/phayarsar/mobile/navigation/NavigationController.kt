package com.phayarsar.mobile.navigation

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.phayarsar.mobile.MainViewModel
import com.phayarsar.mobile.ScreenState
import com.phayarsar.setting.SettingScreen
import com.phyarsar.home.detail.DetailScreen
import com.phyarsar.home.HomeEvent
import com.phyarsar.home.HomeScreen
import com.phyarsar.home.HomeViewModel
import com.phyarsar.home.onboarding.SplashScreen
import com.phyarsar.home.onboarding.WelcomeScreen
import com.phyarsar.home.selectedLanguage.SelectLanguageScreen

@Composable
fun NavigationController(
    screenState: ScreenState
) {

    val navController = rememberNavController()
    var showBottomBar by rememberSaveable { mutableStateOf(true) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    showBottomBar = when (navBackStackEntry?.destination?.route) {
        "home" -> true
        "setting" -> true
        else -> false
    }
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
        bottomBar = { if(showBottomBar) BottomNavigation(navController = navController) },
        containerColor = Color.Transparent
    ) { innerPadding->

        NavHost(
            navController = navController,
            startDestination = startRoute,
            modifier = Modifier.padding(innerPadding)
                .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.1f))
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

                            else ->{
                                Log.d("HomeScreen", "HomeScreen: no event")
                            }
                        }
                    }
                )
            }

            composable(ScreenRoute.DetailScreen.route) {
                DetailScreen()
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