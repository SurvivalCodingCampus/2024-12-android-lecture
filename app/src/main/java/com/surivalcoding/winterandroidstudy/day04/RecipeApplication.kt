package com.surivalcoding.winterandroidstudy.day04

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.surivalcoding.winterandroidstudy.day04.core.di.appModule
import com.surivalcoding.winterandroidstudy.day04.core.di.repositoryModule
import com.surivalcoding.winterandroidstudy.day04.core.di.useCaseModule
import com.surivalcoding.winterandroidstudy.day04.core.di.viewModelModule
import com.surivalcoding.winterandroidstudy.day09_room.di.databaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

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
                databaseModule,
            )
        }
    }
}