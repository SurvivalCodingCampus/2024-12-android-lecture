package com.surivalcoding.winterandroidstudy.day06.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.winterandroidstudy.day04.domain.model.Recipe

@Composable
fun SearchRecipesScreen(
    modifier: Modifier = Modifier,
    state: SearchRecipesState = SearchRecipesState(),
    onQueryChange: (String) -> Unit = {},
) {
    Scaffold { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            TextField(
                value = state.query,
                onValueChange = {
                    onQueryChange(it)
                }
            )

            Text(state.resultTitle)
            Text(state.resultCount)

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalArrangement = Arrangement.spacedBy(15.dp),
            ) {
                items(state.filteredRecipes) { recipe ->
                    Text(
                        recipe.title,
                        modifier = Modifier
                            .background(color = Color.Red)
                            .aspectRatio(1f),
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchRecipesScreenPreview() {
    SearchRecipesScreen(
        state = SearchRecipesState(
            query = "chicken",
            filteredRecipes = listOf(
                Recipe(
                    title = "Spicy fried rice mix chicken bali",
                    chef = "Spicy Nelly"
                ),
                Recipe(
                    title = "Spicy fried rice mix chicken bali",
                    chef = "Spicy Nelly"
                ),
                Recipe(
                    title = "Spicy fried rice mix chicken bali",
                    chef = "Spicy Nelly"
                ),
            )
        )
    )
}