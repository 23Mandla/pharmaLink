package com.example.pharmalink.ui.medication

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.pharmalink.R
import com.example.pharmalink.data.dataclass.Medication
import com.example.pharmalink.ui.components.medication_page.*
import com.example.pharmalink.utils.aippGradientBackground

@Composable
@Preview
fun MedicationPage(
    onSendMessage : (String) -> Unit = {},
    sideEffects: List<String> = emptyList()
){
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

            Column(
                modifier = Modifier
                    .background(colorResource(R.color.mediumNavy))

            ) {
                Row(

                ) {
                    Medication_details(
                        Medication(
                            "Every evening",
                            2,
                            "Diazepam",
                            "Pharmacist",
                            22,
                            strength = "500 mg",
                        )
                    )
                }

                androidx.compose.material3.HorizontalDivider(
                    Modifier
                        .fillMaxWidth(0.8f)
                        .padding(top = 2.dp, start = 13.dp, bottom = 10.dp),
                    DividerDefaults.Thickness,
                    color = Color.White
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    IconButton(
                        onClick = { /*TODO*/ },

                    ) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_arrow_circle_left_24),
                            contentDescription = "Back",
                            tint = colorResource(R.color.lightGrey),
                               
                        )

                    }

                   Row(
                       modifier = Modifier
                           .size(100.dp),
                       horizontalArrangement = Arrangement.SpaceEvenly,
                       verticalAlignment = Alignment.CenterVertically


                   ){
                       MedicationPager()
                   }

                    IconButton(
                        onClick = { /*TODO*/ },

                    ) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_arrow_circle_right_24),
                            contentDescription = "Back",
                            tint = colorResource(R.color.lightGrey),
                        )
                    }
                }
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
                   tint = colorResource(R.color.darkYello),
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

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 13.dp, vertical = 5.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {

                MedicationSchedule()
                MedicationScheduleTimes("10:00 AM")
            }

            // side effects section
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(13.dp)

            ) {
                SideEffectsHeader("Side effects") //TODO change name
            }

            SideEffectsCard(sideEffects)


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(13.dp)

            ) {
                SideEffectsHeader("Contraindications")
            }

            ContraIndications()
        }



        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 13.dp, vertical = 15.dp)
                .align(Alignment.BottomCenter),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
//            OutlinedTextField(
//                modifier = Modifier
//                    .weight(1f),
//                value = message,
//                onValueChange = {
//                    message = it
//                },
//                label = { Text("Enter text") },
//                shape = RoundedCornerShape(8.dp)
//            )
//
//            Spacer(modifier = Modifier.width(8.dp))

            Surface(
                shape = CircleShape,
                color = colorResource(R.color.lighterNavy),
                shadowElevation = 5.dp,
                modifier = Modifier
                    .size(40.dp)

            ) {
                IconButton(
                    onClick = {
                        onSendMessage(message)
                        message = ""
                    },
                    modifier = Modifier
                        .aippGradientBackground()


                ) {
                    Icon(
                        painter = painterResource(R.drawable.aistar),
                        contentDescription = "Search",
                        tint = Color.Blue,
                        modifier = Modifier
                                .size(20.dp),

                    )
                }
            }
        }
    }
}