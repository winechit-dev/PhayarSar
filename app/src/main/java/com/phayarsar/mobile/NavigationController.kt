package com.phayarsar.mobile

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.phyarsar.home.DetailScreenSample
import com.phyarsar.home.HomeEvent
import com.phyarsar.home.HomeScreen
import com.phyarsar.home.SelectLanguageScreen
import com.phyarsar.home.onboarding.WelcomeScreen

@Composable
fun NavigationController() {

    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {

        NavHost(
            navController = navController,
            startDestination = ScreenRoute.SelectLanguage.route,
            modifier = Modifier.padding(it)
        ) {

            composable(ScreenRoute.SelectLanguage.route) {
                SelectLanguageScreen(
                    onClick = { homeEvent ->
                        when (homeEvent) {
                            is HomeEvent.OnNext -> {
                                navController.navigate("welcome")
                            }

                            is HomeEvent.OnBack -> {
                                navController.navigateUp()
                            }
                        }
                    }
                )
            }

            composable(ScreenRoute.WelcomeScreen.route) {
                WelcomeScreen(
                    onClick = { homeEvent ->
                        when (homeEvent) {
                            is HomeEvent.OnNext -> {
                                navController.navigate("home")
                            }

                            is HomeEvent.OnBack -> {
                                navController.navigateUp()
                            }
                        }
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
        }
    }
}

enum class ScreenRoute(val route: String) {
    SelectLanguage(route = "selectLanguage"),
    WelcomeScreen(route = "welcome"),
    HomeScreen(route = "home"),
    DetailScreen(route = "detail")

}