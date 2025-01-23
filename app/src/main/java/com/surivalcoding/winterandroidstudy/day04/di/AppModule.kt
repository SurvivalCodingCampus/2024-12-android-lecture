package com.surivalcoding.winterandroidstudy.day04.di

import com.surivalcoding.winterandroidstudy.data.repository.MockRecipeRepositoryImpl
import com.surivalcoding.winterandroidstudy.data.repository.RecipeRepository
import com.surivalcoding.winterandroidstudy.day04.presentation.saved_recipes.SavedRecipesViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    single<RecipeRepository> { MockRecipeRepositoryImpl() }

//    viewModel { SavedRecipesViewModel(
//        recipeRepository = get()
//    ) }

    // get() 무지성으로 박아주는 매직
    viewModelOf(::SavedRecipesViewModel)
}