package com.example.pharmalink.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun HeaderSection(){
    Row (modifier = Modifier
        .padding(
            horizontal = 16.dp,
            vertical = 24.dp
        )
        .fillMaxWidth()
        .statusBarsPadding(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text("Welcome back Mandla")

    }
}