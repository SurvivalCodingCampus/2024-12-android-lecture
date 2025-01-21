package com.surivalcoding.winterandroidstudy.day07.presentation.a

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.systemBarsPadding(),
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(
                    icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                    selected = false,
                    onClick = {

                    },
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Filled.Add, contentDescription = null) },
                    selected = false,
                    onClick = {

                    },
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Filled.Home, contentDescription = null) },
                    selected = false,
                    onClick = {

                    },
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                    selected = false,
                    onClick = {

                    },
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "MainScreen",
                style = TextStyle(fontSize = 80.sp)
            )
        }
    }
}