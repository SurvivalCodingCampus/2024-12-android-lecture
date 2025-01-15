package com.surivalcoding.winterandroidstudy

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.surivalcoding.winterandroidstudy.day02.Ingredient
import com.surivalcoding.winterandroidstudy.day02.IngredientItem

class MainActivity : ComponentActivity() {
    var count = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        count++
        println("count: $count")
        setContent {
            IngredientItem(
                ingredient = Ingredient(
                    imageUrl = "https://i.namu.wiki/i/Twln-UKmoTWrVDom5UAE85O-8IiNDR0rZT0A1mrWUfgUVLAPD0wL5k-4wEX5e5iHrfYzi00JwynnoZmW9M7JT9mVTU4CU3qXtczVKOmXWvok_1KCFQMM4cKIRFwYU5xiS3ZMxu50QTl0H59vO6pPGA.webp",
                    name = "TODO()",
                    amount = "TODO()"
                )
            )
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("count", count)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt("count")

        // UI 에 복원
    }
}
