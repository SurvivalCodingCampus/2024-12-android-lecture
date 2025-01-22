package com.surivalcoding.winterandroidstudy.day07.presentation.bottomnav

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable


@Composable
fun BottomNavigationScreen(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color.White,
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                BottomNavigationItem(
                    icon = { Icon(Icons.Outlined.Home, contentDescription = null) },
                    label = { Text("Home") },
                    selected = currentDestination?.hierarchy?.any { it.hasRoute(Route.Home::class) } == true,
                    onClick = {
                        navController.navigate(Route.Home) {
                            popUpTo<Route.Home> {
                                inclusive = true
                            }
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
                            popUpTo<Route.Home> {
                                inclusive = true
                                saveState = true
                            }
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
                            popUpTo<Route.Home> {
                                inclusive = true
                                saveState = true
                            }
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
                            popUpTo<Route.Home> {
                                inclusive = true
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    ) {
        NavHost(
            navController = navController,
            modifier = modifier.padding(it),
            startDestination = Route.Home,
        ) {
            composable<Route.Home> {
                HomeScreen()
            }
            composable<Route.Second> {
                SecondScreen()
            }
            composable<Route.Third> {
                ThirdScreen()
            }
            composable<Route.Fourth> {
                FourthScreen()
            }
        }
    }
}

private sealed interface Route {
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
