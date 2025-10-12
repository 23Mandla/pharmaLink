package com.example.pharmalink.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.pharmalink.R

@Composable
@Preview
fun MedsHeader(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(
                vertical = 2.dp, horizontal = 10.dp
            )
            .background(Color.White),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,

    ) {
        Text(
            "Today's medication",
            fontSize = 20.sp,

        )

        IconButton (
            onClick = { /*TODO add filter logic**/ } ,
            modifier = Modifier
                .testTag("filterToggle")
        ) {
            Icon(
                painter = painterResource(R.drawable.filter),
                contentDescription = "filter",
                modifier = Modifier.size(20.dp)
            )
        }
    }
}