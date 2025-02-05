package com.surivalcoding.winterandroidstudy.day04.core.di

import org.koin.dsl.module

val appModule = module {

    single<String> { "생존코딩" }

//    single<RecipeRepository> { MockRecipeRepositoryImpl() }

//    viewModel { SavedRecipesViewModel(
//        recipeRepository = get()
//    ) }

    // get() 무지성으로 박아주는 매직
//    viewModelOf(::SavedRecipesViewModel)
}