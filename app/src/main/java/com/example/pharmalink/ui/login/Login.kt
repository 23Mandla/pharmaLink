package com.example.pharmalink.ui.login

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.text
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.pharmalink.R

@Composable
@Preview
fun Login(onClick: () -> Unit = {}){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var emailError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }

    //TODO Move column and Row inside a box and components
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Login",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .testTag("loginText"),

        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = { Text(
                emailError.ifEmpty { "Email" },
                color = if (emailError.isNotEmpty()) Color.Red else Color.Unspecified,
                modifier = Modifier.testTag("emailLabel")
            ) },
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.baseline_email_24),
                    contentDescription = "Email Icon"
                )
            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 23.dp)
                .testTag("emailField")
                .semantics {
                    contentDescription = ""
                    text = AnnotatedString(email)
                },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = { Text(
                passwordError.ifEmpty { "Password" },
                color = if (passwordError.isNotEmpty()) Color.Red else Color.Unspecified,
                modifier = Modifier.testTag("passwordLabel")
            ) },
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.baseline_lock_24),
                    contentDescription = "Password Icon"
                )
            },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (passwordVisible)
                    painterResource(R.drawable.baseline_visibility_24)
                else
                    painterResource(R.drawable.baseline_visibility_off_24)
                Icon(
                    painter = image,
                    contentDescription = "Password Toggle",
                    modifier = Modifier.clickable {passwordVisible = !passwordVisible}
                )

            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 23.dp)
                .testTag("passwordField"),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 23.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Remember Me",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold

            )

            Text(
                text = "Forgot Password?",
                color = Color.Blue,
                modifier = Modifier.clickable{
                    //TODO forgot password logic
                },
                fontSize = 14.sp,

            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                emailError = if (email.isBlank()) "Email is required!" else ""
                passwordError = if (password.isBlank()) "Password is required!" else ""
                if(emailError.isEmpty() && passwordError.isEmpty()) {
                    onClick()
                }

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 23.dp)
                .testTag("loginButton"),
            shape = RoundedCornerShape(8.dp),
        ) {
            Text(
                text = "Login",
                fontSize = 16.sp,

            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Text(text = "Don't have an account ?")
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Sign Up",
                modifier = Modifier.clickable {
                    //TODO handle sign up logic
                },
                color = Color.Blue
            )

        }
    }
}