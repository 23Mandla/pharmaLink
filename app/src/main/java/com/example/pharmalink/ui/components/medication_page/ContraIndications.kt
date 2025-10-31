package com.example.pharmalink.ui.components.medication_page

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pharmalink.R

@Composable
@Preview
fun ContraIndications(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 13.dp)
            .border(1.dp, Color.Black, RoundedCornerShape(10.dp)),

    ) {

        Text(
            "Health tip",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .padding(top = 5.dp, start = 8.dp)

        )

      Text(
          "Stay hydrated when taking medicine",
          fontSize = 16.sp,
          color = Color.Black,
          modifier = Modifier
              .padding(top = 5.dp, bottom = 8.dp, start = 8.dp)

      )
    }

}