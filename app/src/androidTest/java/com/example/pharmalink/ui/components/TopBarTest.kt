package com.example.pharmalink.ui.components

import androidx.compose.material3.*
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule

import org.junit.Before
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test

class TopBarTest {

    @get:Rule
    val rule = createComposeRule()

    @OptIn(ExperimentalMaterial3Api::class)
    @Before
    fun setup() {
        rule.setContent {
            TopBar(scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior())
        }
    }

    @Test
    fun topBarContent() {
        rule.onNodeWithTag(
            "userName"
        )
            .assertIsDisplayed()
            .assertTextContains("Dlamini") // should be from database verify

        rule.onNodeWithContentDescription(
            "Profile"
        )
            .assertIsDisplayed()
            .assertHasClickAction()
            .performClick()

        rule.onNodeWithContentDescription(
            "Notifications"
        )
            .assertIsDisplayed()
            .assertHasClickAction()
            .performClick()


    }

    @Ignore("Test coming soon")
    @Test
    fun scrollIntegration() {
        // TODO topBar behaviour when content scrolled
        // waiting for more content in home page

    }

    @Ignore("Test coming soon")
    @Test
    fun landscapeLayout() {
        // TODO TopBar components remains correct and usable when the device is in landscape mode.
    }


}