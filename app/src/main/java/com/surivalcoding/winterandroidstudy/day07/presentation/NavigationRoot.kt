package com.surivalcoding.winterandroidstudy.day07.presentation

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.surivalcoding.winterandroidstudy.day07.presentation.a.MainScreen
import com.surivalcoding.winterandroidstudy.day07.presentation.b.SignInScreen
import com.surivalcoding.winterandroidstudy.day07.presentation.bottomnav.BottomNavigationScreen
import com.surivalcoding.winterandroidstudy.day07.presentation.c.SignUpScreen
import com.surivalcoding.winterandroidstudy.day07.presentation.c.SignUpViewModel
import kotlinx.serialization.Serializable

@Serializable
data object AuthGraph

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
) {
    NavHost(
        navController = navController,
        startDestination = AuthGraph,
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
                    navHostController.navigate(Route.SignIn)
                }
            )
        }
        composable<Route.SignIn> {
            SignInScreen(
                modifier = Modifier.clickable {
                    navHostController.navigate(Route.SignUp(id = 1))
                }
            )
        }
        composable<Route.SignUp> {
//            val id = it.toRoute<Route.SignUp>().id
//            println(id)

            val viewModel: SignUpViewModel = viewModel(
                factory = SignUpViewModel.Factory
            )
            val state by viewModel.state.collectAsStateWithLifecycle()

            SignUpScreen(
                state = state,
                modifier = Modifier.clickable {
                    navHostController.navigate(Route.BottomNav) {
                        popUpTo(Route.Main) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable<Route.BottomNav> {
            BottomNavigationScreen(navHostController)
        }
    }
}

