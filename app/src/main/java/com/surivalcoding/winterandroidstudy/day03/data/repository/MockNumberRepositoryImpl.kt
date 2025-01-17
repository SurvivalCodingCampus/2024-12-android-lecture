package com.surivalcoding.winterandroidstudy.day03.data.repository

class MockNumberRepositoryImpl : NumberRepository {
    private var count = 0

    override fun getNumber(): Int {
        return count
    }

    override fun increaseNumber() {
        count++
    }
}