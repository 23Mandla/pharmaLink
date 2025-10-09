package com.example.pharmalink.ui.medication

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MedicationPage(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Medication Page",
                color = Color.Black
            )
        }
    }
}