package com.example.pharmalink.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.*
import com.example.pharmalink.ui.home.MainPage
import org.junit.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class HeaderSectionTest {
    @get:Rule
    val composeTestRule = createComposeRule()


    @Test
    fun headerSectionTopBar() {
        composeTestRule.setContent {
            HeaderSection()
        }

        val expectedDate = today()
        val actualDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))

        composeTestRule.onNodeWithText(
            "Today"
        )
            .assertIsDisplayed()

        composeTestRule.onNodeWithText(
            expectedDate
        )
            .assertIsDisplayed()

        assert(expectedDate == actualDate)

    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Test
    fun headerSectionWithACustomTopBar() {
        // if topBar is not displayed
        composeTestRule.setContent {
            MainPage(false)
        }

        // confirm that topBar is not displayed
        composeTestRule.onNodeWithTag(
            "topBar"
        )
            .assertIsNotDisplayed()

        // and that header section displays
        composeTestRule.onNodeWithText(
            "Today"
        )
            .assertIsDisplayed()

        composeTestRule.onNodeWithText(
            today()
        )
            .assertIsDisplayed()

    }
}