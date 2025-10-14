package com.example.pharmalink.ui.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.pharmalink.R
import com.example.pharmalink.data.dataclass.Medication

@Composable
fun MedCard(context: Context, medication: Medication, onClick: () -> Unit = {}){
    Card (
        modifier = Modifier
            .size(92.dp)
            .clickable {
                onClick()
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        border = CardDefaults.outlinedCardBorder(),
    ) {

    }
}

@Preview
@Composable
fun MedCardPreview(){
    MedCard(LocalContext.current, Medication(
        "Every evening",
        1,
        "Diazepam",
        "Dev",
        731,
        "10 mg"
    ))
}