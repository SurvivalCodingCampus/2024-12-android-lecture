package com.surivalcoding.winterandroidstudy.day09_room.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.surivalcoding.winterandroidstudy.day09_room.data.local.dao.UserDao
import com.surivalcoding.winterandroidstudy.day09_room.data.local.entity.UserEntity

@Database(entities = [UserEntity::class, ], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}