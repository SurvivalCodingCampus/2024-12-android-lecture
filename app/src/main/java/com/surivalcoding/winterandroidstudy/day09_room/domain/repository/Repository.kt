package com.surivalcoding.winterandroidstudy.day09_room.domain.repository

import com.surivalcoding.winterandroidstudy.day09_room.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getAll(): List<User>
    suspend fun getAllFlow(): Flow<List<User>>

    suspend fun insert(userEntity: User)
    suspend fun upsert(userEntity: User)
    suspend fun delete(userEntity: User)
}