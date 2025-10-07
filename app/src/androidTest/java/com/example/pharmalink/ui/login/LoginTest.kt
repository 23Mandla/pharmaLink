package com.example.pharmalink.ui.login

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.*
import com.example.pharmalink.ui.theme.PharmaLinkTheme
import com.example.pharmalink.utils.TextChange
import com.example.pharmalink.utils.ToggleBtn
import org.junit.*


class LoginTest {
    @get:Rule
    val rule = createComposeRule()

    @Before
    fun setup() {
        rule.setContent {
            PharmaLinkTheme {
                Login()
            }
        }
    }

    @Test
    fun testUiState() {

        rule.onNodeWithTag("loginText").assertIsDisplayed()

        val emailField = rule.onNodeWithTag(
            "emailField"
        )
        emailField.assertIsDisplayed()

        rule.onNodeWithText(
            "Email"
        )
            .assertExists()

        val passwordField = rule.onNodeWithTag(
            "passwordField"
        )
        passwordField.assertIsDisplayed()

        rule.onNodeWithText(
            "Password"
        )
            .assertExists()

        rule.onNodeWithText(
            "Remember Me"
        )
            .assertIsDisplayed()

        rule.onNodeWithText(
            "Forgot Password?"
        )
            .assertIsDisplayed()

        rule.onNodeWithTag(
            "loginButton"
        )
            .assertIsDisplayed()
    }

    @Test
    fun emailPasswordState() {
        // email text change
        TextChange("emailField", "j.doe@gmail.com", rule)

        // password text change
        TextChange("passwordField", "password", rule)

    }

    @Test
    fun passwordFunctionality() {

        val btnToggle = ToggleBtn()

        rule.onNodeWithTag(
            "passwordField"
        )
            .performTextInput("secrete")

        rule.onNodeWithTag(
            "passwordToggle"
        )
            .assertIsDisplayed()
            .performClick()

    }

    @Ignore("Test coming soon")
    @Test
    fun loginFields() {
        // TODO display 'Email is required!' and 'Password is required!' error messages on button click
    }

    @Ignore("Test coming soon")
    @Test
    fun emptyFields() {
        // TODO show corresponding email error message and does not trigger the onClick lambda and label text color
    }


    @Ignore("Test coming soon")
    @Test
    fun longInput() {
        // Test the UI's behavior and rendering when a very long string is entered into the email field to check for any text overflow or layout issues.
        // TODO implement test
    }


    @Ignore("Test coming soon")
    @Test
    fun whiteSpaceCharacters() {
        // TODO white spaces in fields
    }

    @Ignore("Test coming soon")
    @Test
    fun clickAbleTexts() {
        // Verify that the 'Forgot Password?' text is clickable, although no action is currently implemented (TODO).
        // TODO 'Forgot Password?' and 'Sign Up' text is a clickable action
    }

    @Ignore("Test coming soon")
    @Test
    fun uiStateRecompositions() {
        // TODO input data (email, password) and UI state (password visibility) are preserved during recomposition, for example, on device rotation.
    }

}