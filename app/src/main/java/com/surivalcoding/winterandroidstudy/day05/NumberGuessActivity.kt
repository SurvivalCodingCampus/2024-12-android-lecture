package com.surivalcoding.winterandroidstudy.day05

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.surivalcoding.winterandroidstudy.day05.presentation.NumberGuessScreen
import com.surivalcoding.winterandroidstudy.day05.presentation.NumberGuessViewModel


class NumberGuessActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: NumberGuessViewModel = viewModel()
            val state = viewModel.state.collectAsStateWithLifecycle()

            NumberGuessScreen(
                state = state.value,
                onValueChange = { newText ->
                    viewModel.onNumberTextChange(newText)
                },
                onGuessClick = {
                    viewModel.onGuessClick()
                }
            )
        }
    }
}