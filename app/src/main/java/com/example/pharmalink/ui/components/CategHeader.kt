package com.example.pharmalink.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
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
fun CategHeader(){
    //TODO note code repetition: can be one header with MedsHeader
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(
                top = 22.dp,
                bottom = 1.dp,
                start = 13.dp,
                end = 13.dp

            )
            .background(Color.White),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Text(
            "Categories",
            fontSize = 19.sp,

            )

        Text(
            "View All",
            fontSize = 15.sp,
            color = colorResource(R.color.lightNavy)

            )
    }
}