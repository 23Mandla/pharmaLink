package com.example.pharmalink.utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalDivider(){
    HorizontalDivider(
        Modifier
            .fillMaxWidth(0.8f)
            .padding(top = 15.dp),
        DividerDefaults.Thickness,
        DividerDefaults.color
    )
}