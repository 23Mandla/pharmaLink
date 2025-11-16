package com.example.pharmalink.ui.components.medication_page

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
fun MedicationScheduleTimes(
    time: String = ""){

    // another repetition
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 13.dp, vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically


    ) {
        TimeLineInv(
            modifier = Modifier
                .weight(1f)
                .height(2.dp),
            color = Color.Transparent
        )

        MedicationScheduleControl(

            time = "10:00 AM"
        )

        TimeLineInv(
            modifier = Modifier
                .weight(1f)
                .height(2.dp),
            color = Color.Transparent
        )

        MedicationScheduleControl(

            time = "14:00 PM"
        )

        TimeLineInv(
            modifier = Modifier
                .weight(1f)
                .height(2.dp),
            color = Color.Transparent
        )

        MedicationScheduleControl(

            time = "18:00 PM"
        )

        TimeLineInv(
            modifier = Modifier
                .weight(1f)
                .height(2.dp),
            color = Color.Transparent
        )
    }

}

@Composable
fun MedicationScheduleControl(
    time: String = ""
){
    Column(

    ) {

        Text(
            time,
            fontSize = 12.sp,
            color = Color.Black
        )
    }
}

@Composable
fun TimeLineInv(
    modifier: Modifier,
    color: Color
) {

    Box(
        modifier = modifier
            .height(2.dp)
            .background(color)

    )
}
