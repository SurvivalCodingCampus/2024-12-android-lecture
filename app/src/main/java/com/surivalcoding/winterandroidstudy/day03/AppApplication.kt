package com.surivalcoding.winterandroidstudy.day03

import android.app.Application
import com.surivalcoding.winterandroidstudy.day03.data.repository.MockNumberRepositoryImpl
import com.surivalcoding.winterandroidstudy.day03.data.repository.NumberRepository

class AppApplication : Application() {
    // 싱글턴으로 쓰겠다
    val numberRepository: NumberRepository by lazy {
        MockNumberRepositoryImpl()
    }
}