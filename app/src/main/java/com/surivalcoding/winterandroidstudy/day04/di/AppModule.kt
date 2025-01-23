package com.surivalcoding.winterandroidstudy.day04.di

import com.surivalcoding.winterandroidstudy.data.repository.MockRecipeRepositoryImpl
import com.surivalcoding.winterandroidstudy.data.repository.RecipeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(): RecipeRepository {
        return MockRecipeRepositoryImpl()
    }
}