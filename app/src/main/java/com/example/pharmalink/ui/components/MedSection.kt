package com.example.pharmalink.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.*
import androidx.navigation.NavHostController
import com.example.pharmalink.data.dataclass.Medication
import com.example.pharmalink.R
import com.example.pharmalink.data.viewmodel.MedicationState
import com.example.pharmalink.utils.HorizontalDivider

@Composable

fun MedSection(
    medicationState: MedicationState,
    navController: NavHostController? = null,
    onMedClick: (Medication) -> Unit = {}
){
    val context = LocalContext.current
    //    Log.d("MedicationState", medicationState.toString())

    val medications = medicationState.medication
    // for prototyping
    //first row mes
    val firstRowMeds = medications.take(3)
    //second row mes
    val secondRowMeds = medications.drop(3).take(3)

    Log.d("MedicationState", firstRowMeds.toString())
    Log.d("MedicationState", secondRowMeds.toString())

   val containerGradient = Brush.verticalGradient(
       colors = listOf(
           Color(0xFF89C8FF),
           Color(0xFFA0C8FD),
           Color(0xFFCEE5FA),
           Color(0xFFDCEDFC),

       )
   )

    // TODO prioritize meds
   Box(
       modifier = Modifier
           .wrapContentSize()
           .padding(horizontal = 13.dp)
           .background(Color.Transparent)

   ){
       Box(
           modifier = Modifier
               .fillMaxWidth()
               .clip(RoundedCornerShape(16.dp))
               .background(containerGradient)


       ){

           Card (
               modifier = Modifier
                   .fillMaxWidth()

                   .align(Alignment.TopCenter)
                   .border(1.dp, Color.LightGray, RoundedCornerShape(16.dp)),
               shape = RoundedCornerShape(16.dp),
               colors = CardDefaults.cardColors(
                   containerColor = Color.Transparent

               ),

               ) {

               // fix this this
               LazyRow(
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(top = 13.dp),
                   horizontalArrangement = Arrangement.SpaceEvenly
               ) {
                   //val sideEffectsJson = Uri.encode(Gson().toJson(sideEffects))
                   items(firstRowMeds){ medication ->

                       MedCard(
                           context,
                            medication,
                           {
                              // navController?.navigate("medicationPage/$sideEffectsJson")
                           }
                       )
                   }
               }

               LazyRow(
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(top = 13.dp),
                   horizontalArrangement = Arrangement.SpaceEvenly

               ) {
                   items(secondRowMeds){ medication ->
                       MedCard(
                           context,
                           medication
                       )
                   }
               }

               // should be it's own composable

               Column (
                   modifier = Modifier
                       .fillMaxWidth()
                       .background(
                           Color.Transparent
                       )
                       .padding(top = 20.dp),
                   horizontalAlignment = Alignment.CenterHorizontally,

                   ) {

                   HorizontalDivider()

                   Button(
                       onClick = { /*TODO*/ },
                       modifier = Modifier
                           .fillMaxWidth(),

                       colors = ButtonDefaults.buttonColors(
                           containerColor = Color.Transparent,

                           )

                   ) {

                       Row(
                           modifier = Modifier
                               .fillMaxWidth(),
                           horizontalArrangement = Arrangement.Center,
                           verticalAlignment = Alignment.CenterVertically

                       ){
                           Text(
                               "View All",
                               fontSize = 12.sp,
                               modifier = Modifier
                                   .padding(end = 8.dp)
                           )

                           Icon(
                               painter = painterResource(R.drawable.baseline_keyboard_arrow_down_24),
                               contentDescription = "View All",
                               tint = Color.Black
                           )
                       }
                   }
               }
           }
       }
   }
}
