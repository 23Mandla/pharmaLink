package com.example.pharmalink.utils

import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput

fun TextChange(
    tag: String,
    textChange: String,
    rule: ComposeTestRule
)  {

    if (tag == "emailField") {
        rule.onNodeWithTag(
            tag
        )
            .assertExists()
            .performClick()
            .performTextInput(textChange)

        rule.onNodeWithTag(
            tag
        )
            .assertTextContains(textChange)

        rule.onNodeWithTag(
            "loginButton"
        )
            .assertIsEnabled()
    } else if (tag == "passwordField") {
        rule.onNodeWithTag(
            tag
        )
            .assertExists()
            .performClick()
            .performTextInput(textChange)

        rule.onNodeWithTag(
            tag
        )
            .assertTextContains(textChange)

        rule.onNodeWithTag(
            "loginButton"
        )
    }
}