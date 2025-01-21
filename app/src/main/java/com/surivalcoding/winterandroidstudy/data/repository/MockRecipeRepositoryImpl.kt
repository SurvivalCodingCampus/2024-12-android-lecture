package com.surivalcoding.winterandroidstudy.data.repository

import com.surivalcoding.winterandroidstudy.data.model.Recipe

class MockRecipeRepositoryImpl : RecipeRepository {
    override suspend fun getSavedRecipes(): List<Recipe> {
        return listOf(
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
            )
        )
    }
}