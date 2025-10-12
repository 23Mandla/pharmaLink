package com.example.pharmalink.ui.components

import android.text.format.DateUtils.isToday
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pharmalink.R

@Composable
@Preview
fun WeekDayCard(day: String = "Mon",date: String = "12", isToday: Boolean = false){
    Card(
        modifier = Modifier
            .size(60.dp)

    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    if (isToday) colorResource(R.color.seafoamBlue)
                    else
                        colorResource(R.color.lightGrey)

                ),
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {

            Text(
                day,
                color = if (isToday) Color.White else Color.Black,
                modifier = Modifier.padding(top = 8.dp),

                fontSize = 13.sp,
                fontWeight = MaterialTheme.typography.titleMedium.fontWeight
            )

            Spacer(modifier = Modifier.height(1.dp))

            Text(
                date,
                color = if (isToday) Color.White else Color.Black,
                fontSize = 13.sp,
                modifier = Modifier

            )
        }
    }
}