package com.surivalcoding.winterandroidstudy.day01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class StatelessComposableActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstComposable(
                text = "헬로",
                onClick = {
                    println("클릭!!!!")
                }
            )
        }
    }
}

@Composable
fun MyFirstComposable(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {}
) {
    Text(
        text = text,
        modifier = Modifier.clickable {
            onClick()
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun MyFirstComposablePreview() {
    MyFirstComposable(
        text = "헬로"
    )
}