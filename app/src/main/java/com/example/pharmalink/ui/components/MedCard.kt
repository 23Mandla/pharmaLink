package com.example.pharmalink.ui.components

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.pharmalink.R
import com.example.pharmalink.data.dataclass.Medication

// TODO code from chatgbt, Change before pushing
@Composable
fun MedCard(
    context: Context,
    medication: Medication,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .clip(RoundedCornerShape(10.dp))
            .clickable { onClick() }
            .graphicsLayer {

                compositingStrategy = CompositingStrategy.Offscreen
                alpha = 0.99f
            }
            .drawWithContent {

                drawRect(
                    Color.White.copy(alpha = 0.5f),
                    blendMode = BlendMode.SrcOver
                )
                drawContent()
            }
            .background(Color.White.copy(alpha = 0.15f))
            .border(1.dp, Color.White.copy(alpha = 0.5f), RoundedCornerShape(16.dp))
            .padding(top = 13.dp),

    ) {
        // inner column
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .background(
                    Color.Transparent
                )

        ) {
            val dp = if (addMedication(medication.medicationName).length <= 8) 12.5.dp else 5.dp

            Text(
                addMedication(medication.medicationName),
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Color.Black,
                modifier = Modifier.padding(end = dp)
            )

            Spacer(modifier = Modifier.height(6.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    medication.strength,
                    fontSize = 12.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 4.dp, end = 12.dp)
                )
                Image(
                    painter = painterResource(R.drawable.capsule),
                    contentDescription = "Medication",
                    modifier = Modifier
                        .size(25.dp)
                        .padding(end = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

             Row(
                 verticalAlignment = Alignment.CenterVertically,
                 modifier = Modifier.fillMaxWidth(),

             ) {
                 Text(
                     "10 AM",
                     color = colorResource(R.color.darkGreen),
                     fontSize = 12.sp,
                     modifier = Modifier.padding(start = 4.dp)
                 )

                 Spacer(modifier = Modifier.width(3.dp))

                 Box(
                     modifier = Modifier
                         .height(1.dp)
                         .width(30.dp)
                         .background(
                             Color.DarkGray
                         )
                 )

             }
        }
    }
}

fun addMedication(string: String): String {
    return (
            if(string.length > 8){
                string.substring(0, 8) + "..."
            } else {
                string
            })
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
        "10 mg",
    ))
}