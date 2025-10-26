package com.example.pharmalink.ui.components

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.navigation.NavHostController
import com.example.pharmalink.data.dataclass.Medication
import com.google.gson.Gson
import com.example.pharmalink.R

@Composable
@Preview
fun MedSection(
    sideEffects: List<String> = emptyList(),
    navController: NavHostController? = null,
    onMedClick: (Medication) -> Unit = {}
){
    val context = LocalContext.current

    // TODO prioritize meds
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 13.dp)
            .background(Color.White)
            .border(1.dp, Color.LightGray, RoundedCornerShape(16.dp)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,

    ) {

        // fix this this
       LazyRow(
           modifier = Modifier
               .fillMaxWidth(),

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
                .fillMaxWidth(),

            ) {
            items(3){
                MedCard(
                    context,
                    Medication(
                        "Every evening",
                        1,
                        "Diazepam",
                        "Dev",
                        731,
                        "10 mg"
                    )
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 13.dp),
            horizontalArrangement = Arrangement.SpaceBetween,

            ) {

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Bottom),
                shape = RoundedCornerShape(
                    bottomStart = 16.dp,
                    bottomEnd = 16.dp
                )

            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically

                ){
                    Text(
                        "View All",
                        fontSize = 12.sp,
                        color = Color.White,
                    )

                    Icon(
                        painter = painterResource(R.drawable.baseline_drag_handle_24),
                        contentDescription = "View All",
                    )
                }
            }
        }
    }
}
