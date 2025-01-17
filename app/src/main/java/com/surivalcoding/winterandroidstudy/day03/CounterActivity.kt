package com.surivalcoding.winterandroidstudy.day03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import com.surivalcoding.winterandroidstudy.day03.presentation.counter.CounterScreen
import com.surivalcoding.winterandroidstudy.day03.presentation.counter.CounterViewModel
import com.surivalcoding.winterandroidstudy.ui.theme.WinterAndroidStudyTheme

class CounterActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: CounterViewModel by viewModels()

        setContent {
            WinterAndroidStudyTheme {
                val count by viewModel.count
                CounterScreen(
                    count = count,
                    onClick = {
                        viewModel.increase()
                    }
                )
            }
        }
    }
}