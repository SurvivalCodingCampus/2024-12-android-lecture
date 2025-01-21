package com.surivalcoding.winterandroidstudy.day06

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.surivalcoding.winterandroidstudy.day06.presentation.SearchRecipesScreen
import com.surivalcoding.winterandroidstudy.day06.presentation.SearchRecipesViewModel
import com.surivalcoding.winterandroidstudy.ui.theme.WinterAndroidStudyTheme

class SearchRecipesActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WinterAndroidStudyTheme {
                val viewModel: SearchRecipesViewModel = viewModel()
                val state by viewModel.state.collectAsStateWithLifecycle()

                SearchRecipesScreen(
                    state = state,
                    onQueryChange = {
//                        viewModel.fetchRecipes(it)
                        Intent()
                    }
                )
            }
        }
    }
}


class B(
    private val id: Int
) {

}