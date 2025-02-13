package com.surivalcoding.winterandroidstudy.day12_service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyService : Service() {
    private val job = SupervisorJob()

    // Service의 생명주기에 맞춘 코루틴 스코프
    private val scope = CoroutineScope(Dispatchers.IO + job)

    private val binder = LocalBinder()

    private var _count = 10
    val count = _count

    inner class LocalBinder : Binder() {
        // Return this instance of LocalService so clients can call public methods.
        fun getService(): MyService = this@MyService
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // 어디선가 startService() 로 호출하면 여기가 호출 됨
        intent?.let {
            val name = intent.getStringExtra("name")
            val age = intent.getIntExtra("age", 0)
            println("$name $age")

            when (it.action) {
                "play" -> {
                    println("play")
                }

                "stop" -> {
                    println("stop")
                    stopSelf()
                }
            }
        }

        scope.launch {
            repeat(10) {
                println(it)
                delay(1000)
                _count--
            }
            stopSelf()
        }

        println("onStartCommand")
//        ServiceCompat.startForeground(this, )
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        // 서비스가 종료될 때 모든 코루틴을 취소
        job.cancel()
    }
}