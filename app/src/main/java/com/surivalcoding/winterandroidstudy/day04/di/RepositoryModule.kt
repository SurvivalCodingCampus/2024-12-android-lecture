package com.surivalcoding.winterandroidstudy.day04.di

import com.surivalcoding.winterandroidstudy.data.repository.MockRecipeRepositoryImpl
import com.surivalcoding.winterandroidstudy.data.repository.RecipeRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<RecipeRepository> { MockRecipeRepositoryImpl() }
}