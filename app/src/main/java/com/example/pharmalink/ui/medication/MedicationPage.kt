package com.example.pharmalink.ui.medication

import android.content.res.Resources
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.pharmalink.R
import com.example.pharmalink.data.dataclass.Medication
import com.example.pharmalink.ui.components.medication_page.*

@Composable
@Preview
fun MedicationPage(onSendMessage : (String) -> Unit = {}){
    var message by remember {
        mutableStateOf("")
    }
    
    //TODO remove dummy times and add logic
    val times = listOf(
        "10:00 AM",
        "14:00 PM",
        "18:00 PM",
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()

                    .background(colorResource(R.color.mediumNavy)),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.medication),
                    contentDescription = "Medication",
                    modifier = Modifier
                        .size(70.dp)
                )
            }

            Row(

            ) {
                Medication_details(
                    Medication(
                        "Every evening",
                        2,
                        "Paracetamol",
                        "Pharmacist",
                        22,
                        strength = "500 mg",
                    )
                )
            }

            // schedule section
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 13.dp, vertical = 5.dp)

            ) {
                SideEffectsHeader("Schedule") //TODO change name
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 13.dp),
                verticalAlignment = Alignment.CenterVertically

            ) {
               Icon(
                   painter = painterResource(R.drawable.baseline_star_24),
                   contentDescription = "Schedule",
                   tint = Color.Yellow,
                   modifier = Modifier
                       .size(20.dp)

               )

                Text(
                    "After meal",
                    modifier = Modifier
                        .padding(start = 2.dp),
                    fontSize = 14.sp,
                    color = Color.Gray

                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 13.dp, vertical = 5.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)

            ) {

                times.forEach {
                    MedicationSchedule(it)
                }

            }

            // side effects section
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(13.dp)

            ) {
                SideEffectsHeader("Side effects") //TODO change name
            }

            SideEffectsCard(listOf(
                "Nausea",
                "Stomach pain",
                "Vomiting",
                "Constipation")
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 13.dp, vertical = 15.dp)
                .align(Alignment.BottomCenter),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .weight(1f),
                value = message,
                onValueChange = {
                    message = it
                },
                label = { Text("Enter text") },
                shape = RoundedCornerShape(8.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Surface(
                shape = CircleShape,
                color = colorResource(R.color.lighterNavy),
                shadowElevation = 1.dp,
                modifier = Modifier
                    .size(50.dp)

            ) {
                IconButton(
                    onClick = {
                        onSendMessage(message)
                        message = ""
                    },

                ) {
                    Icon(
                        painter = painterResource(R.drawable.aistar),
                        contentDescription = "Search",
                        tint = Color.White,
                        modifier = Modifier
                                .size(30.dp)
                    )
                }
            }
        }
    }
}