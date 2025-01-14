package com.surivalcoding.winterandroidstudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val expanded = remember { mutableStateOf(false) }

            val extraPadding by animateDpAsState(
                if (expanded.value) 48.dp else 0.dp
            )

            Column(
                modifier = Modifier.fillMaxSize(),
            ) {
                repeat(10) {
                    Text("Hello World")
                }
                Text(
                    text = "Hello World",
                    modifier = Modifier.padding(16.dp),
                )
                Text(
                    "Hello World",
                    style = TextStyle(
                        color = Color.Red,
                        fontSize = 20.sp,
                    )
                )

                Row(
                    modifier = Modifier
                        .padding(24.dp)
                        .background(color = Color.Gray)
                ) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(bottom = extraPadding)
                    ) {
                        Text("Hello World")
                        Text("Hello World")
                    }

                    ElevatedButton(
                        onClick = {
                            expanded.value = !expanded.value
                        }
                    ) {
                        Text(text = if (expanded.value) "줄이기" else "더 보기")
                    }
                }
            }
        }
    }
}
