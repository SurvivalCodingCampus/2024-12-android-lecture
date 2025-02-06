package com.surivalcoding.winterandroidstudy.day09_room.data.local

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.surivalcoding.winterandroidstudy.day09_room.data.local.dao.UserDao
import com.surivalcoding.winterandroidstudy.day09_room.data.local.entity.UserEntity
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class AppDatabaseTest {
    private lateinit var userDao: UserDao

    @Before
    fun setUp() {
        val db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java,
        ).build()

        userDao = db.userDao()
    }

    @Test
    fun userDao() = runTest {
        userDao.upsert(UserEntity(firstName = "junsuk", lastName = "oh"))
        userDao.upsert(UserEntity(firstName = "석봉", lastName = "한"))

        val users = userDao.getAll()
        assertTrue(users.size == 2)
    }
}