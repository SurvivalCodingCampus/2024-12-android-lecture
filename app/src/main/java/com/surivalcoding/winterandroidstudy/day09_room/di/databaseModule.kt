package com.surivalcoding.winterandroidstudy.day09_room.di

import androidx.room.Room
import com.surivalcoding.winterandroidstudy.day09_room.data.local.AppDatabase
import com.surivalcoding.winterandroidstudy.day09_room.data.local.dao.UserDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single<AppDatabase> {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            "recipe.db"
        ).build()
    }

    single<UserDao> {
        get<AppDatabase>().userDao()
    }
}