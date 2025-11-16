package com.example.pharmalink.utils

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun Modifier.aippGradientBackground() = this.background(
    brush = Brush.linearGradient(
        colors = listOf(
            Color(0xFF864DFF),
            Color(0xFF00bf63)
        )
    )
)