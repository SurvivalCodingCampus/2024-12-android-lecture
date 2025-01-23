package com.surivalcoding.winterandroidstudy.day04.core.di

import com.surivalcoding.winterandroidstudy.day04.domain.use_case.DeleteBookmarkUseCase
import com.surivalcoding.winterandroidstudy.day04.domain.use_case.GetSavedRecipesUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetSavedRecipesUseCase(get(), get()) }
    single { DeleteBookmarkUseCase(get(), get()) }
}