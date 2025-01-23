package com.surivalcoding.winterandroidstudy.day04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.surivalcoding.winterandroidstudy.day04.presentation.saved_recipes.SavedRecipesScreen
import com.surivalcoding.winterandroidstudy.day04.presentation.saved_recipes.SavedRecipesViewModel
import com.surivalcoding.winterandroidstudy.ui.theme.WinterAndroidStudyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val viewModel: SavedRecipesViewModel by viewModels()

        setContent {
            WinterAndroidStudyTheme {
                val viewModel: SavedRecipesViewModel = hiltViewModel()
                val savedRecipes = viewModel.savedRecipes.collectAsState()

                SavedRecipesScreen(
                    savedRecipes = savedRecipes.value,
                )
            }
        }
    }
}