package com.surivalcoding.winterandroidstudy.day02

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.annotation.ExperimentalCoilApi
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
            model = if (LocalInspectionMode.current) {
                R.drawable.ic_launcher_background
            } else {
                ingredient.imageUrl
            },
            contentDescription = "아이유",
            placeholder = painterResource(R.drawable.ic_launcher_foreground)
        )
        Text(ingredient.name)
        Text("${ingredient.amount}g")
    }
}

@OptIn(ExperimentalCoilApi::class)
@Preview(showBackground = true)
@Composable
private fun IngredientItemPreview() {
    IngredientItem(
        ingredient = Ingredient(
            imageUrl = "https://i.namu.wiki/i/Twln-UKmoTWrVDom5UAE85O-8IiNDR0rZT0A1mrWUfgUVLAPD0wL5k-4wEX5e5iHrfYzi00JwynnoZmW9M7JT9mVTU4CU3qXtczVKOmXWvok_1KCFQMM4cKIRFwYU5xiS3ZMxu50QTl0H59vO6pPGA.webp",
            name = "토마토",
            amount = "500"
        )
    )

}