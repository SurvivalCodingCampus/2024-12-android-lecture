package com.surivalcoding.winterandroidstudy.day07.presentation

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.surivalcoding.winterandroidstudy.day07.presentation.a.MainScreen
import com.surivalcoding.winterandroidstudy.day07.presentation.b.SignInScreen
import com.surivalcoding.winterandroidstudy.day07.presentation.bottomnav.BottomNavigationScreen
import com.surivalcoding.winterandroidstudy.day07.presentation.c.SignUpScreenRoot
import kotlinx.serialization.Serializable

@Serializable
data object AuthGraph

@Serializable
data object MainGraph

sealed interface Route {
    @Serializable
    data object Main : Route

    @Serializable
    data object SignIn : Route

    @Serializable
    data class SignUp(val id: Int) : Route

    @Serializable
    data object BottomNav : Route
}

@Composable
fun NavigationRoot(
    navController: NavHostController,
    isLogin: Boolean,
) {
    NavHost(
        navController = navController,
        startDestination = if (isLogin) MainGraph else AuthGraph,
    ) {
        authGraph(navController)
    }
}

private fun NavGraphBuilder.authGraph(navHostController: NavHostController) {
    navigation<AuthGraph>(
        startDestination = Route.Main
    ) {
        composable<Route.Main> {
            MainScreen(
                modifier = Modifier.clickable {
                    navHostController.navigate(Route.SignIn) {
                        popUpTo<Route.Main> {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable<Route.SignIn> {
            SignInScreen(
                modifier = Modifier.clickable {
                    navHostController.navigate(Route.SignUp(id = 1)) {
                        popUpTo<Route.SignIn> {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable<Route.SignUp> {
            SignUpScreenRoot(
                onSignUp = {
                    navHostController.navigate(Route.BottomNav) {
                        popUpTo<Route.SignUp> {
                            inclusive = true
                        }
                    }
                },
                onSignIn = {},
                onBack = {},
            )
        }
        composable<Route.BottomNav> {
            BottomNavigationScreen()
        }
    }
}

