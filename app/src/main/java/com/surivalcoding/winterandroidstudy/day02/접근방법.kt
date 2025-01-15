package com.surivalcoding.winterandroidstudy.day02

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.surivalcoding.winterandroidstudy.R

data class Ingredient(
    val imageUrl: String,
    val name: String,
    val amount: String
)

@Composable
fun IngredientItem(
    ingredient: Ingredient,
    modifier: Modifier = Modifier,
) {
    Row {
        AsyncImage(
            modifier = Modifier
                .size(100.dp),
            contentScale = ContentScale.Crop,
            model = "https://img1.newsis.com/2024/05/27/NISI20240527_0001559783_web.jpg?rnd=20240527092454",
            contentDescription = "아이유",
            placeholder = painterResource(R.drawable.ic_launcher_foreground)
        )
        Text(ingredient.name)
        Text("${ingredient.amount}g")
    }
}

@Preview(showBackground = true)
@Composable
private fun IngredientItemPreview() {
    IngredientItem(
        ingredient = Ingredient(
            imageUrl = "TODO()",
            name = "토마토",
            amount = "500"
        )
    )
}