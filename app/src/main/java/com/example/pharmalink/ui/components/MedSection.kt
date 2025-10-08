package com.example.pharmalink.ui.components

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*

@Composable
fun MedSection(){
    val context = LocalContext.current
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // Adaptive
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .height(500.dp)
    ) {

        items(10) {
            MedCard(
                context = context
            )
        }
    }
}

@Preview
@Composable
fun MedSectionPreview(){
    MedSection()
}