package com.example.pharmalink.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.navigation.NavHostController
import com.example.pharmalink.data.dataclass.Medication

@Composable
@Preview
fun MedSection(
    medications: List<Medication> = emptyList(),
    navController: NavHostController? = null,
    onMedClick: (Medication) -> Unit = {}
){
    val context = LocalContext.current

    // TODO prioritize meds
    Column (

        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,

    ) {

        //TODO NB in dev

       Row(
           modifier = Modifier
               .fillMaxWidth()
               .padding(vertical = 10.dp),
           horizontalArrangement = Arrangement.SpaceEvenly,

       ) {
           repeat(3){
               //TODO get med card over here
               Card(
                   modifier = Modifier
                       .size(90.dp)
                       .clickable {
                          //TODO med card is clickable
                       },
                   colors = CardDefaults.cardColors(
                       containerColor = Color.White
                   ),
                   border = CardDefaults.outlinedCardBorder(),
               ) {

               }
           }

       }

        Spacer(modifier = Modifier.height(2.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,

            ) {
            repeat(3){
                //TODO get med card over here
                Card(
                    modifier = Modifier
                        .size(95.dp)
                        .clickable {
                            //TODO med card is clickable
                        },
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    border = CardDefaults.outlinedCardBorder(),
                ) {

                }
            }
        }
    }
}
