package com.surivalcoding.winterandroidstudy.day10_broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

// https://developer.android.com/develop/background-work/background-tasks/broadcasts/broadcast-exceptions?hl=ko&_gl=1*kc4cy9*_up*MQ..*_ga*MjIzMTgzMjE2LjE3MzkxNjc4MzI.*_ga_6HH9YJMN9M*MTczOTE2NzgzMi4xLjAuMTczOTE2Nzk3MC4wLjAuMTQ2OTc3OTM4Mg..
class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        when (intent.action) {
            Intent.ACTION_TIMEZONE_CHANGED -> {
                // 오래 걸리는 처리, 비동기 처리 하면 안 됨 X
                // 10초안에 끝나는 거만 해야 됨
                Toast.makeText(context, "타임존 변경 되었음", Toast.LENGTH_SHORT).show()
            }
            MY_ACTION -> {
                Toast.makeText(context, "MY_ACTION", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        const val MY_ACTION = "com.surivalcoding.winterandroidstudy.action.MY_ACTION"
    }
}