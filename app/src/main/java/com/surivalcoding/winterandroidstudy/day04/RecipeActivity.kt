package com.surivalcoding.winterandroidstudy.day04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import com.surivalcoding.winterandroidstudy.day04.presentation.saved_recipes.SavedRecipesScreen
import com.surivalcoding.winterandroidstudy.day04.presentation.saved_recipes.SavedRecipesViewModel
import org.koin.compose.viewmodel.koinViewModel

class RecipeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val viewModel: SavedRecipesViewModel by viewModels()


        setContent {
            val viewModel: SavedRecipesViewModel = koinViewModel()
            val savedRecipes = viewModel.savedRecipes.collectAsState()

            SavedRecipesScreen(
                savedRecipes = savedRecipes.value,
                onBookmarkClick = {
                    viewModel.onDeleteBookmark(it)
                }
            )
        }
    }
}