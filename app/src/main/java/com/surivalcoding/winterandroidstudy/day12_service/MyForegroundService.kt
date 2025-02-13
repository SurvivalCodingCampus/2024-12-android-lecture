package com.surivalcoding.winterandroidstudy.day12_service

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.pm.ServiceInfo
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.app.PendingIntentCompat
import androidx.core.app.ServiceCompat
import androidx.core.content.PermissionChecker
import com.surivalcoding.winterandroidstudy.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyForegroundService : Service() {
    private val job = SupervisorJob()

    // Service의 생명주기에 맞춘 코루틴 스코프
    private val scope = CoroutineScope(Dispatchers.IO + job)

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    private fun checkNotificationPermission(
        onGranted: () -> Unit,
    ) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val permission =
                PermissionChecker.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)

            if (permission != PermissionChecker.PERMISSION_GRANTED) {
                stopSelf()
            } else {
                onGranted()
            }

        }
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is not in the Support Library.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "CHANNEL 이름"
            val descriptionText = "CHANNEL_ID"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel("CHANNEL_ID", name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system.
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        createNotificationChannel()

        checkNotificationPermission {
            val serviceActivityIntent = Intent(this, ServiceActivity::class.java)
            serviceActivityIntent.flags =
                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            val pendingIntent =
                PendingIntentCompat.getActivity(
                    this,
                    0,
                    serviceActivityIntent,
                    PendingIntent.FLAG_ONE_SHOT,
                    false
                )

            val notification = NotificationCompat.Builder(this, "CHANNEL_ID")
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle("textTitle")
                .setContentText("textContent")
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .build()

            ServiceCompat.startForeground(
                this,
                100, // Cannot be 0
                notification,
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
                    ServiceInfo.FOREGROUND_SERVICE_TYPE_SHORT_SERVICE
                } else {
                    0
                }
            )
        }


        scope.launch {
            repeat(10) {
                println(it)
                delay(1000)
            }
        }

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        job.cancel()
        super.onDestroy()
    }
}