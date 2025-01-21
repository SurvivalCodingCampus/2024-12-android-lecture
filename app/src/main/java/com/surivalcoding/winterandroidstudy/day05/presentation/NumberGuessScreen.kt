package com.surivalcoding.winterandroidstudy.day05.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun NumberGuessScreen(
    modifier: Modifier = Modifier,
    state: NumberGuessState = NumberGuessState(),
    onValueChange: (String) -> Unit = {},
    onGuessClick: () -> Unit = {},
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        TextField(
            value = state.numberText,
            onValueChange = {
                onValueChange(it)
            }
        )
        Button(
            onClick = {
                onGuessClick()
            }
        ) {
            Text("맞추기")
        }
        Text(state.guessText ?: "")
    }
}

@Preview(showBackground = true)
@Composable
private fun NumberGuessScreenPreview() {
    NumberGuessScreen(
        state = NumberGuessState(
            numberText = "100",
        )
    )
}