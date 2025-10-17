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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pharmalink.R
import com.example.pharmalink.data.dataclass.Medication
import com.example.pharmalink.ui.components.medication_page.Medication_details
import com.example.pharmalink.ui.components.medication_page.SideEffectsHeader

@Composable
@Preview
fun MedicationPage(onSendMessage : (String) -> Unit = {}){
    var message by remember {
        mutableStateOf("")
    }
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

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(13.dp)

            ) {
                SideEffectsHeader()
            }
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(13.dp)
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