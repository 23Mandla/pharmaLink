package com.example.pharmalink.ui.components.medication_page

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pharmalink.R

@Composable
@Preview
fun MedicationSchedule(time: String = "10:00 AM"){
    // another repetition
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 13.dp, vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically


    ) {
        TimeLine(
            modifier = Modifier
                .weight(1f)
                .height(2.dp),
            color = Color.Gray
        )

        MedicationScheduleControl(
            size = 20.dp,
            color = colorResource(R.color.lightGrey),
            modifier = Modifier,
            time = "10:00"
        )

        TimeLine(
            modifier = Modifier
                .weight(1f)
                .height(2.dp),
            color = Color.Gray
        )

        MedicationScheduleControl(
            size = 20.dp,
            color = colorResource(R.color.lightGrey),
            modifier = Modifier,
            time = "14:00"
        )

        TimeLine(
            modifier = Modifier
                .weight(1f)
                .height(2.dp),
            color = Color.Gray
        )

        MedicationScheduleControl(
            size = 20.dp,
            color = colorResource(R.color.lightGrey),
            modifier = Modifier,
            time = "18:00"
        )

        TimeLine(
            modifier = Modifier
                .weight(1f)
                .height(2.dp),
            color = Color.Gray
        )
    }

}

@Composable
fun MedicationScheduleControl(
    size : Dp,
    color: Color,
    onClick: () -> Unit = {},
    modifier: Modifier,
    time: String = ""
){
    Column(

    ) {

        Surface(
            shape = CircleShape,
            border = BorderStroke(1.dp, Color.Black),
            color = color,
            modifier = modifier
                .size(size)
                .clickable { onClick() }
        ) {

        }

    }
}

@Composable
fun TimeLine(
    modifier: Modifier,
    color: Color
){

    Box(
        modifier = modifier
            .height(2.dp)
            .background(color)

    )

}