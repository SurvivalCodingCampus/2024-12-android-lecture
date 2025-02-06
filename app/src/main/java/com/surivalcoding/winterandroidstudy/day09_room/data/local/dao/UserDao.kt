package com.surivalcoding.winterandroidstudy.day09_room.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.surivalcoding.winterandroidstudy.day09_room.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    suspend fun getAll(): List<UserEntity>

    @Query("SELECT * FROM user")
    fun getAllFlow(): Flow<List<UserEntity>>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    suspend fun loadAllByIds(userIds: IntArray): List<UserEntity>

    @Query("SELECT * FROM user WHERE firstName LIKE :first AND " +
           "lastName LIKE :last LIMIT 1")
    suspend fun findByName(first: String, last: String): UserEntity

    @Upsert
    suspend fun upsert(userEntity: UserEntity)

//    @Insert
//    fun insert(user: User)
//
//    @Update
//    fun update(user: User)

    @Delete
    suspend fun delete(userEntity: UserEntity)
}