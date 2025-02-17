package com.surivalcoding.winterandroidstudy.day04.core.di

import com.surivalcoding.winterandroidstudy.day04.presentation.saved_recipes.SavedRecipesViewModel
import com.surivalcoding.winterandroidstudy.day14_network_connectivity.presentation.NetworkConnectivityViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::SavedRecipesViewModel)
    viewModelOf(::NetworkConnectivityViewModel)
}