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
            .fillMaxWidth()
            .clickable {
                onClick()
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        border = CardDefaults.outlinedCardBorder(),
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.pill_color),
                    contentDescription = "pill",
                    modifier = Modifier
                        .size(40.dp)

                )

                Text(
                    "09:00 AM",
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.height(7.dp))

            Text(
                medication.medicationName,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                medication.dosage
            )
        }
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