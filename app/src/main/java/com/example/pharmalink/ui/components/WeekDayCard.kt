package com.example.pharmalink.ui.components

import android.text.format.DateUtils.isToday
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pharmalink.R

@Composable
@Preview
fun WeekDayCard(day: String = "Mon",date: String = "12", isToday: Boolean = false){

    val backgroundColor = if (isToday) {
        MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
    } else {
        Color.White.copy(alpha = 0.30f)
    }

    val contentColor = if (isToday) {
        Color.White
    } else {
        Color.Black
    }

    Box(
        modifier = Modifier
            .size(60.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(1.dp, Color.LightGray, RoundedCornerShape(16.dp))

    ){
        Box(
            modifier = Modifier
                .matchParentSize()
                .clip(RoundedCornerShape(16.dp))
                .background(
                    backgroundColor
                )

            )

        Box(
            modifier = Modifier
                .matchParentSize()
                .clip(RoundedCornerShape(16.dp))
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color.White.copy(alpha = 0.1f), Color.White.copy(alpha = 0.04f)),
                        start = Offset(0f, 0f),
                        end = Offset(1000f, 1000f)
                    )
                )
                .blur(radius = 16.dp),

        )

           Column(
               modifier = Modifier
                   .fillMaxSize(),
               horizontalAlignment = Alignment.CenterHorizontally,

           ) {


               Spacer(modifier = Modifier.height(2.dp))

               Text(
                   date,
                   color = contentColor,
                   fontSize = 13.sp,

               )

               Text(
                   day,
                   color = contentColor,
                   fontSize = 13.sp,
                   fontWeight = MaterialTheme.typography.titleMedium.fontWeight
               )

           }
    }
}