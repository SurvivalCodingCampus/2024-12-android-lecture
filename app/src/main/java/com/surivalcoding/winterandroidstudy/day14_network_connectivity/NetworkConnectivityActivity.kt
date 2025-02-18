package com.surivalcoding.winterandroidstudy.day14_network_connectivity

import android.os.Bundle
import android.webkit.WebView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.surivalcoding.winterandroidstudy.day14_network_connectivity.presentation.NetworkConnectivityScreen
import com.surivalcoding.winterandroidstudy.day14_network_connectivity.presentation.NetworkConnectivityState
import com.surivalcoding.winterandroidstudy.day14_network_connectivity.presentation.NetworkConnectivityViewModel
import com.surivalcoding.winterandroidstudy.day14_network_connectivity.ui.theme.WinterKotilnStudyTheme
import org.koin.compose.viewmodel.koinViewModel

class NetworkConnectivityActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val textView = WebView(this)

        enableEdgeToEdge()
        setContent {
            WinterKotilnStudyTheme {
                val viewModel: NetworkConnectivityViewModel = koinViewModel()
                val state by viewModel.state.collectAsState()

                NetworkConnectivityScreen(
                    state = state,
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    WinterKotilnStudyTheme {
        NetworkConnectivityScreen(
            state = NetworkConnectivityState.Available
        )
    }
}