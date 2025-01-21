package com.surivalcoding.winterandroidstudy.day07.presentation.bottomnav

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import kotlinx.serialization.Serializable


@Composable
fun BottomNavigationScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                BottomNavigationItem(
                    icon = { Icon(Icons.Filled.Home, contentDescription = null) },
                    label = { Text("Home") },
                    selected = currentDestination?.hierarchy?.any { it.hasRoute(Route.Home::class) } == true,
                    onClick = {
                        navController.navigate(Route.Home) {
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Filled.Add, contentDescription = null) },
                    label = { Text("Second") },
                    selected = currentDestination?.hierarchy?.any { it.hasRoute(Route.Second::class) } == true,
                    onClick = {
                        navController.navigate(Route.Second) {
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Filled.Call, contentDescription = null) },
                    label = { Text("Third") },
                    selected = currentDestination?.hierarchy?.any { it.hasRoute(Route.Third::class) } == true,
                    onClick = {
                        navController.navigate(Route.Third) {
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Filled.Done, contentDescription = null) },
                    label = { Text("Fourth") },
                    selected = currentDestination?.hierarchy?.any { it.hasRoute(Route.Fourth::class) } == true,
                    onClick = {
                        navController.navigate(Route.Fourth) {
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {

        }
//        NavHost(
//            navController,
//            modifier = modifier.padding(it),
//            startDestination = Route.Home,
//        ) {
//            composable<Route.Home> {
//                HomeScreen()
//            }
//            composable<Route.Second> {
//                SecondScreen()
//            }
//            composable<Route.Third> {
//                ThirdScreen()
//            }
//            composable<Route.Fourth> {
//                FourthScreen()
//            }
//        }
    }
}

sealed interface Route {
    @Serializable
    data object Home : Route

    @Serializable
    data object Second : Route

    @Serializable
    data object Third : Route

    @Serializable
    data object Fourth : Route
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    // center text
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Home")
    }
}

@Composable
fun SecondScreen(modifier: Modifier = Modifier) {
    // center text
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Second")
    }
}

@Composable
fun ThirdScreen(modifier: Modifier = Modifier) {
    // center text
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Third")
    }
}

@Composable
fun FourthScreen(modifier: Modifier = Modifier) {
    // center text
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Fourth")
    }
}


class BottomNavigationViewModel : ViewModel() {

}