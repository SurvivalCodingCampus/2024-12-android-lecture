package com.surivalcoding.winterandroidstudy.day10_broadcast

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.surivalcoding.winterandroidstudy.day10_broadcast.ui.theme.WinterAndroidStudyTheme

class BroadcastActivity : ComponentActivity() {
    private val myBroadcastReceiver = MyReceiver()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val filter = IntentFilter(MyReceiver.MY_ACTION)

        ContextCompat.registerReceiver(
            applicationContext,
            myBroadcastReceiver,
            filter,
            ContextCompat.RECEIVER_EXPORTED,
        )

        enableEdgeToEdge()
        setContent {
            WinterAndroidStudyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BroadcastScreen(
                        modifier = Modifier.padding(innerPadding),
                        onMyAction = {
                            sendBroadcast(
                                Intent(MyReceiver.MY_ACTION)
                            )
                        }
                    )
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        // 화면 켜질 때
    }

    override fun onPause() {
        super.onPause()
        // 화면 꺼질 때
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myBroadcastReceiver)
    }
}

@Composable
fun BroadcastScreen(
    modifier: Modifier = Modifier,
    onMyAction: () -> Unit = {

    }
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            onMyAction()
        }) {
            Text("My Action 발송")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WinterAndroidStudyTheme {
        BroadcastScreen()
    }
}