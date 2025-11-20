package com.example.pharmalink.ui.components

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.navigation.NavHostController
import com.example.pharmalink.data.dataclass.Medication
import com.google.gson.Gson
import com.example.pharmalink.R
import com.example.pharmalink.utils.HorizontalDivider

@Composable
@Preview
fun MedSection(
    sideEffects: List<String> = emptyList(),
    navController: NavHostController? = null,
    onMedClick: (Medication) -> Unit = {}
){
    val context = LocalContext.current

   val containerGradient = Brush.verticalGradient(
       colors = listOf(
           Color(0xFFCCE7FF),
           Color(0xFFBEE1FF),
           Color(0xFFCCE7FF),
           Color(0xFFD6ECFF),

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
//        Image(
//            painter = painterResource(R.drawable.med_wave),
//            contentDescription = null,
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .matchParentSize()
//                .padding(horizontal = 13.dp)
//                .clip(RoundedCornerShape(16.dp)),
//
//        )

           Card (
               modifier = Modifier
                   .fillMaxWidth()

                   .align(Alignment.TopCenter)
//            .paint(
//                painterResource(R.drawable.med_wave),
//                contentScale = ContentScale.FillBounds
//            )
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
                   val sideEffectsJson = Uri.encode(Gson().toJson(sideEffects))
                   items(3){

                       MedCard(
                           context,
                           Medication(
                               "Every evening",
                               1,
                               "Diazepam",
                               "Dev",
                               731,
                               "10 mg",
                           ),
                           {
                               navController?.navigate("medicationPage/$sideEffectsJson")
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
                   items(3){
                       MedCard(
                           context,
                           Medication(
                               "Every evening",
                               1,
                               "Paracetamol",
                               "Dev",
                               731,
                               "500 mg"
                           )
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
