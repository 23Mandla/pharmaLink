package com.example.pharmalink.ui.components.medication_page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pharmalink.data.dataclass.Medication

@Composable
fun Medication_details(medication: Medication) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(13.dp)
            .wrapContentHeight()
    ) {
        Text(
            text = medication.medicationName, // OOP principles. name variable easily accessible
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold

        )

        Spacer(modifier = Modifier.height(5.dp))

        Row(

        ) {
            Text(
                text = medication.strength, // OOP principles. name variable easily accessible
                color = Color.White,
                fontSize = 16.sp,

            )

            Spacer(modifier = Modifier.width(20.dp))

            Text(
                text = "Tablets", // OOP principles. name variable easily accessible
                color = Color.White,
                fontSize = 16.sp,

            )

            Spacer(modifier = Modifier.width(20.dp))

            Text(
                text = "25", // OOP principles. name variable easily accessible
                color = Color.White,
                fontSize = 16.sp,

                )
        }
    }
}

@Preview
@Composable
fun Medication_details(){
    Medication_details(
        Medication(
            "Every evening",
            2,
            "Paracetamol",
            "Pharamcist",
            22,
            strength = "500 mg",
        )
    )
}