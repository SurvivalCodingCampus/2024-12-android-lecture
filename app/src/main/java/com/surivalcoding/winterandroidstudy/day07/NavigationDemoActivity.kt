package com.surivalcoding.winterandroidstudy.day07

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.surivalcoding.winterandroidstudy.day07.presentation.NavigationRoot
import com.surivalcoding.winterandroidstudy.ui.theme.WinterAndroidStudyTheme

class NavigationDemoActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WinterAndroidStudyTheme {
                val navController = rememberNavController()

                NavigationRoot(
                    navController = navController,
                    isLogin = false,
                )
            }
        }
    }
}
