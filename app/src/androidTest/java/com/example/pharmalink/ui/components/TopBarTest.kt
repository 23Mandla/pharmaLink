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
        // Pass a `TopAppBarScrollBehavior` and simulate a scroll gesture to verify the TopAppBar's position and height changes accordingly.
        //  with a null or default (non-scrolling) behavior to ensure it remains fixed
        // TODO implement test

    }

    @Ignore("Test coming soon")
    @Test
    fun landscapeLayout() {
        // Verify that the layout of the `TopBar` components remains correct and usable when the device is in landscape mode.
        // TODO implement test
    }


}