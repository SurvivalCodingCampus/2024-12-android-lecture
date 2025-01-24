package com.surivalcoding.winterandroidstudy.day07.presentation.c

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SignUpScreenRoot(
    onSignUp: () -> Unit = {},
    onSignIn: () -> Unit = {},
    onBack: () -> Unit = {},
) {
    val viewModel = viewModel<SignUpViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    SignUpScreen(
        state = state,
        onAction = { action ->
            when(action) {
                is SignUpAction.InputEmail -> TODO()
                is SignUpAction.InputName -> {
                }
                SignUpAction.OnClickSignUp -> {
                    onSignUp()
                }
                SignUpAction.OnClickTerms -> {
                    viewModel.onAction(SignUpAction.OnClickTerms)
                }
            }

        }
    )
}