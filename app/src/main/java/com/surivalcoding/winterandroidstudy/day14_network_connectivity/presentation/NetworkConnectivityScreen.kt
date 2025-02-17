package com.surivalcoding.winterandroidstudy.day14_network_connectivity.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun NetworkConnectivityScreen(
    modifier: Modifier = Modifier,
    state: NetworkConnectivityState,
) {
    Scaffold {
        Box(
            modifier = modifier
                .padding(it)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(if (state == NetworkConnectivityState.Available) "연결됨" else "연결 안 됨")
        }
    }
}