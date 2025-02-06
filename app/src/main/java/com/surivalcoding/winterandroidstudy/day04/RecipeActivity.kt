package com.surivalcoding.winterandroidstudy.day04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.surivalcoding.winterandroidstudy.day04.presentation.saved_recipes.SavedRecipesScreenRoot

class RecipeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val viewModel: SavedRecipesViewModel by viewModels()

        setContent {
            SavedRecipesScreenRoot()
        }
    }
}