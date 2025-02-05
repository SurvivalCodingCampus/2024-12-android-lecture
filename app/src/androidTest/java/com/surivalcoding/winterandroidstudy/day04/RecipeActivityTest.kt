package com.surivalcoding.winterandroidstudy.day04

import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class RecipeActivityTest {

    @get:Rule
    val testRule = createAndroidComposeRule<RecipeActivity>()

    @Test
    fun `첫번째_아이템_삭제`() {
        testRule.apply {
            onNodeWithTag("button_0").performClick()

            waitForIdle()

            onNodeWithTag("button_0").assertIsNotDisplayed()
        }
    }
}