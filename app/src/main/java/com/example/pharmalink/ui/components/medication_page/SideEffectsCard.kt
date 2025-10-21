package com.example.pharmalink.ui.components.medication_page

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pharmalink.R
import com.example.pharmalink.ui.components.today

@Composable
@Preview
fun SideEffectsCard(sideEffects: List<String> = emptyList()){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 13.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.lightGrey)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            
            Icon(
                painter = painterResource(R.drawable.aistar),
                contentDescription = null,
                modifier = Modifier
                    .size(25.dp),
                tint = Color.Yellow
            )

            Text(
                "side effects provided by ai...",
                modifier = Modifier
                    .padding(start = 5.dp),
                fontSize = 10.sp,
                color = Color.Black

            )
        }

        Text(
            "Common side effects",
            modifier = Modifier
                .padding(horizontal = 13.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black

            )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, end = 0.dp, bottom = 5.dp, top = 0.dp),
            horizontalAlignment = Alignment.Start,

        ) {
            if(sideEffects.isNotEmpty()){
                sideEffects.forEach {
                        effect ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(1.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(12.dp)
                                .padding(end = 4.dp)
                                .background(
                                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.4f),
                                    shape = CircleShape

                                )
                        ){

                        }
                        Text(
                            text = effect,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Black

                        )
                    }
                }
            }else{
                Text(
                    text = "No side effects found",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Blue,
                    modifier = Modifier
                        .padding(top = 10.dp)
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 13.dp, end = 13.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                "Intelligent insights and more...",
                fontSize = 14.sp,
                color = Color.Black
            )

            IconButton (
                onClick = { /*TODO intelligent page*/} ,
                modifier = Modifier
                    .testTag("passwordToggle"),

            ) {
                Icon(
                    painter = painterResource(R.drawable.baseline_arrow_right_alt_24),
                    contentDescription = "Password Toggle",
                    tint = colorResource(R.color.mediumNavy)
                )
            }
        }
    }
}