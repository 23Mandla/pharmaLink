package com.example.pharmalink.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pharmalink.R

@Composable
@Preview
fun Categories(){
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 13.dp, horizontal = 13.dp),
        horizontalArrangement = Arrangement.spacedBy(25.dp),

        ) {
        items(
            4
        ) {

            //TODO get category card
            Card(
                modifier = Modifier
                    .size(92.dp)
                    .clickable {
                        //TODO med card is clickable
                    },
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                border = CardDefaults.outlinedCardBorder(),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Image(
                        painter = painterResource(R.drawable.heart_cat),
                        contentDescription = "pill",
                        modifier = Modifier.size(40.dp)

                    )
                    Text(
                        "Heart",
                        color = Color.Black
                    )
                }

            }
        }
    }
}