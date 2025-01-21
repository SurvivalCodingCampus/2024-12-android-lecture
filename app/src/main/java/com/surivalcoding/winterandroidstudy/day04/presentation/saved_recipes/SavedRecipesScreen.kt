package com.surivalcoding.winterandroidstudy.day04.presentation.saved_recipes

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.winterandroidstudy.data.model.Recipe

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavedRecipesScreen(
    modifier: Modifier = Modifier,
    savedRecipes: List<Recipe>,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Saved Recipes")
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = modifier.padding(innerPadding),
            contentPadding = PaddingValues(
                horizontal = 30.dp,
                vertical = 10.dp,
            ),
        ) {
            items(savedRecipes.size) { index ->
                Text(savedRecipes[index].title)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SavedRecipesScreenPreview() {
    SavedRecipesScreen(
        savedRecipes = listOf(
            Recipe(
                title = "Traditional spare ribs baked",
                chef = "Chef John"
            ),
            Recipe(
                title = "Spice roasted chicken with flavored rice",
                chef = "Mark Kelvin"
            ),
            Recipe(
                title = "Spicy fried rice mix chicken bali",
                chef = "Spicy Nelly"
            ),
            Recipe(
                title = "Ttekbokki",
                chef = "Kim Dahee"
            ),
            Recipe(
                title = "Grilled salmon with avocado salsa",
                chef = "Alice Johnson"
            ),
            Recipe(
                title = "Beef Wellington",
                chef = "Gordon Ramsay"
            ),
            Recipe(
                title = "Classic Margherita Pizza",
                chef = "Mario Batali"
            ),
            Recipe(
                title = "Sushi Platter",
                chef = "Jiro Ono"
            ),
            Recipe(
                title = "French Onion Soup",
                chef = "Julia Child"
            ),
            Recipe(
                title = "Chocolate Lava Cake",
                chef = "Paul Hollywood"
            ),
        ),
    )
}