package com.surivalcoding.winterandroidstudy.day09_room.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.surivalcoding.winterandroidstudy.day09_room.data.local.dao.UserDao
import com.surivalcoding.winterandroidstudy.day09_room.data.local.entity.UserEntity
import com.surivalcoding.winterandroidstudy.day09_room.domain.model.User
import com.surivalcoding.winterandroidstudy.day09_room.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserRepositoryImpl(
    private val userDao: UserDao,
    private val dataStore: DataStore<Preferences>,
) : UserRepository {

    private val EXAMPLE_COUNTER = stringPreferencesKey("user_name")


    suspend fun insertUser2(user: User) {
        dataStore.edit { settings ->
            settings[EXAMPLE_COUNTER] = user.name
        }
    }

    override suspend fun getAll(): List<User> {
        return userDao.getAll().map { entity ->
            User(
                name = entity.firstName + entity.lastName,
                age = 0,
            )
        }
    }

    override suspend fun getAllFlow(): Flow<List<User>> {
        return userDao.getAllFlow().map { entityList ->
            entityList.map { entity ->
                User(
                    name = entity.firstName + entity.lastName,
                    age = 0,
                )
            }
        }
    }

    override suspend fun insert(user: User) {
        // user -> entity
        val userEntity = UserEntity(
            uid = 0,
            firstName = user.name,
            lastName = "",
        )

        return userDao.upsert(userEntity)
    }

    override suspend fun upsert(user: User) {
        // user -> entity
        val userEntity = UserEntity(
            uid = 0,
            firstName = user.name,
            lastName = "",
        )
        return userDao.upsert(userEntity)
    }

    override suspend fun delete(user: User) {
        // user -> entity
        val userEntity = UserEntity(
            uid = 0,
            firstName = user.name,
            lastName = "",
        )
        return userDao.delete(userEntity)
    }
}