package com.surivalcoding.winterandroidstudy.day09_room.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

// DTO 같은 놈
// DB 정보를 그대로 담을 놈
@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val uid: Int? = null,
    val firstName: String,
    val lastName: String,
)