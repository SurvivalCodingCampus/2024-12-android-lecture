package com.surivalcoding.winterandroidstudy.day04.presentation.saved_recipes

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.surivalcoding.winterandroidstudy.day04.domain.model.Recipe
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SavedRecipesScreenRoot(
    viewModel: SavedRecipesViewModel = koinViewModel()
) {
    val savedRecipes = viewModel.savedRecipes.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    val context = LocalContext.current

    LaunchedEffect(viewModel) {
        viewModel.event.collect { event ->
            when (event) {
                is SavedRecipesEvent.ShowDialog -> {
                    Toast.makeText(context, event.message, Toast.LENGTH_SHORT).show()
                    snackbarHostState.showSnackbar(
                        message = event.message,
                        duration = SnackbarDuration.Short,
                        actionLabel = "실행 취소",
                    )
                }
                is SavedRecipesEvent.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(
                        message = event.message,
                        duration = SnackbarDuration.Short,
                        actionLabel = "실행 취소",
                    )
                }
            }
        }
    }

    SavedRecipesScreen(
        savedRecipes = savedRecipes.value,
        snackbarHostState = snackbarHostState,
        onBookmarkClick = {
            viewModel.onDeleteBookmark(it)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavedRecipesScreen(
    modifier: Modifier = Modifier,
    savedRecipes: List<Recipe>,
    onBookmarkClick: (Recipe) -> Unit = {},
    snackbarHostState: SnackbarHostState,
) {
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
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
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row {
                        Text(savedRecipes[index].title)
                        Button(onClick = {
                            onBookmarkClick(savedRecipes[index])
                        }) {
                            Text("삭제")
                        }
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//private fun SavedRecipesScreenPreview() {
//    SavedRecipesScreen(
//        savedRecipes = listOf(
//            Recipe(
//                title = "Traditional spare ribs baked",
//                chef = "Chef John"
//            ),
//            Recipe(
//                title = "Spice roasted chicken with flavored rice",
//                chef = "Mark Kelvin"
//            ),
//            Recipe(
//                title = "Spicy fried rice mix chicken bali",
//                chef = "Spicy Nelly"
//            ),
//            Recipe(
//                title = "Ttekbokki",
//                chef = "Kim Dahee"
//            ),
//            Recipe(
//                title = "Grilled salmon with avocado salsa",
//                chef = "Alice Johnson"
//            ),
//            Recipe(
//                title = "Beef Wellington",
//                chef = "Gordon Ramsay"
//            ),
//            Recipe(
//                title = "Classic Margherita Pizza",
//                chef = "Mario Batali"
//            ),
//            Recipe(
//                title = "Sushi Platter",
//                chef = "Jiro Ono"
//            ),
//            Recipe(
//                title = "French Onion Soup",
//                chef = "Julia Child"
//            ),
//            Recipe(
//                title = "Chocolate Lava Cake",
//                chef = "Paul Hollywood"
//            ),
//        ),
//    )
//}