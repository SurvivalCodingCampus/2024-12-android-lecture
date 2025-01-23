package com.surivalcoding.winterandroidstudy.day04

import android.app.Application
import com.surivalcoding.winterandroidstudy.day04.core.di.appModule
import com.surivalcoding.winterandroidstudy.day04.core.di.repositoryModule
import com.surivalcoding.winterandroidstudy.day04.core.di.useCaseModule
import com.surivalcoding.winterandroidstudy.day04.core.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RecipeApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@RecipeApplication)

            modules(
                appModule,
                repositoryModule,
                viewModelModule,
                useCaseModule,
            )
        }
    }
}