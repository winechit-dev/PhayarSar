package com.phayarsar.mobile.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.phayarsar.design_system.theme.ThemePreviews
import com.phayarsar.mobile.R

@Composable
fun BottomNavigation(navController: NavHostController) {

    val bottomNavRouteList = listOf(
        BottomNavRoute.Home,
        BottomNavRoute.Setting
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 66.dp, vertical = 20.dp)
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(40.dp)
            )
            .padding(4.dp),
        horizontalArrangement = Arrangement.Center
    ) {

        bottomNavRouteList.forEach { bottomNavRoute ->

            NavigationItem(
                bottomNavRoute = bottomNavRoute,
                onClick = {
                    navController.navigate(bottomNavRoute.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                },
                isSelected = currentDestination?.route == bottomNavRoute.route
            )
        }
    }
}

@Composable
fun NavigationItem(
    bottomNavRoute: BottomNavRoute,
    onClick: () -> Unit,
    isSelected: Boolean
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(
                color = if (isSelected) MaterialTheme.colorScheme.onPrimary else Color.Transparent,
                shape = RoundedCornerShape(40.dp)
            )
            .clickable { onClick() }
            .padding(horizontal = 40.dp, vertical = 20.dp)
    ) {
        Icon(
            painter = painterResource(
                id = when (bottomNavRoute.route) {
                    "home" -> R.drawable.ic_home
                    "setting" -> R.drawable.ic_setting
                    else -> {
                        R.drawable.ic_home
                    }
                }
            ),
            contentDescription = bottomNavRoute.route,
            tint = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.size(24.dp)
        )

        if (isSelected) {
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = bottomNavRoute.route,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@ThemePreviews
@Composable
fun PreviewNavigationItem() {
    NavigationItem(BottomNavRoute.Home, {}, isSelected = true)
}

@ThemePreviews
@Composable
fun PreviewBottomNavigation() {
    BottomNavigation(NavHostController(LocalContext.current))
}


sealed class BottomNavRoute(val route: String) {
    data object Home : BottomNavRoute("home")
    data object Setting : BottomNavRoute("setting")

}