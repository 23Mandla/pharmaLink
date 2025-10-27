package com.example.pharmalink.ui.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.pharmalink.R
import com.example.pharmalink.data.dataclass.Medication

@Composable
fun MedCard(
    context: Context,
    medication: Medication,
    onClick: () -> Unit = {}
){
    Card (
        modifier = Modifier
            .clickable {
                onClick()
            }
            .wrapContentSize()
            .padding(start = 12.dp, top = 12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        border = CardDefaults.outlinedCardBorder(),
    ) {
        
        Text(
            "Diazepam",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, start = 10.dp, end = 5.dp),
            fontWeight = MaterialTheme.typography.titleMedium.fontWeight,
            fontSize = 15.sp

        )

       Row(
           modifier = Modifier
               .fillMaxWidth()
               .padding(vertical = 3.dp),
           verticalAlignment = Alignment.CenterVertically,
       ) {
           Text(
               "500 mg",
               modifier = Modifier
                   .padding(start = 10.dp, end = 16.dp),
               fontSize = 12.sp
           )
           Image(
               painter = painterResource(R.drawable.capsule),
               contentDescription = "Medication",
               modifier = Modifier
                   .size(25.dp)
                   .padding(end = 10.dp),
               alignment = Alignment.Center
           )
       }

        Text(
            "10 AM",
            modifier = Modifier
                .padding(start = 10.dp, bottom = 8.dp),
            fontSize = 12.sp,
            color = colorResource(R.color.darkGreen)
        )
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