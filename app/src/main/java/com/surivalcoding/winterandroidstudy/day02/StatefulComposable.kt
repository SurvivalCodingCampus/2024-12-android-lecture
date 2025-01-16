package com.surivalcoding.winterandroidstudy.day02

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Composable
fun CounterScreen(
    count: Int = 0,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        TextButton(
            onClick = {
                onClick()
            }
        ) {
            Text(
                text = "$count",
                style = TextStyle(fontSize = 80.sp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CounterPreview() {
    CounterScreen(
        count = 5
    )
}