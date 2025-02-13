package com.surivalcoding.winterandroidstudy.day12_service

import android.Manifest
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
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
import com.surivalcoding.winterandroidstudy.day12_service.ui.theme.WinterAndroidStudyTheme

class ServiceActivity : ComponentActivity() {
    private lateinit var mService: MyService
    private var mBound: Boolean = false

    private val connection = object : ServiceConnection {

        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance.
            val binder = service as MyService.LocalBinder
            mService = binder.getService()
            mBound = true
        }

        override fun onServiceDisconnected(arg0: ComponentName) {
            mBound = false
        }
    }

    private val notificationPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
            if (granted) {
                // Notification permission granted
                val intent = Intent(applicationContext, MyForegroundService::class.java)
                ContextCompat.startForegroundService(applicationContext, intent)
            } else {
                // Notification permission denied
                // 이 권한을 수락 안 하면 뭐 할 때 뭐가 안된다
                // 자세한 권한 수동으로 설정을 해야한다는 문구 표시
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WinterAndroidStudyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding),
                        onStartService = {
                            val intent = Intent(applicationContext, MyService::class.java)
                            intent.putExtra("name", "홍길동")
                            intent.putExtra("age", 10)
                            intent.action = "play"
                            startService(intent)
                        },
                        onStopService = {
                            val intent = Intent(applicationContext, MyService::class.java)
                            stopService(intent)
                        },
                        onStartForegroundService = {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                                notificationPermission.launch(Manifest.permission.POST_NOTIFICATIONS)
                            } else {
                                val intent =
                                    Intent(applicationContext, MyForegroundService::class.java)
                                ContextCompat.startForegroundService(applicationContext, intent)
                            }
                        },
                        onBindService = {
                            val intent = Intent(this, MyService::class.java)
                            bindService(intent, connection, Context.BIND_AUTO_CREATE)
                        },
                        getCount = {
                            Toast.makeText(this, "${mService.count}", Toast.LENGTH_SHORT).show()
                        },
                        onUnbindService = {
                            unbindService(connection)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(
    modifier: Modifier = Modifier,
    onStartService: () -> Unit = {},
    onStopService: () -> Unit = {},
    onStartForegroundService: () -> Unit = {},
    onBindService: () -> Unit = {},
    getCount: () -> Unit = {},
    onUnbindService: () -> Unit = {},
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = onStartService) {
            Text("Start Service")
        }
        Button(onClick = onStopService) {
            Text("Stop Service")
        }
        Button(onClick = onStartForegroundService) {
            Text("Start ForegroundService")
        }
        Button(onClick = onBindService) {
            Text("Start bind Service")
        }
        Button(onClick = getCount) {
            Text("bind 된 Service 에서 값 가져오기")
        }
        Button(onClick = onUnbindService) {
            Text("unbind Service")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    WinterAndroidStudyTheme {
        Greeting()
    }
}