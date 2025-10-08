package com.example.pharmalink.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.pharmalink.R
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun HeaderSection(topBar: @Composable () -> Unit = {}){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(10.dp),

        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.lightNavy)
        ),
        shape = RoundedCornerShape(16.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, bottom = 30.dp, top = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            Text(
                "Today",
                fontSize = 20.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                today(),
                fontSize = 16.sp,
                color = Color.White,

            )
        }
    }
}

// return today's date
@RequiresApi(Build.VERSION_CODES.O)
fun today(): String {
    val today = LocalDate.now()
    val date = DateTimeFormatter.ofPattern("dd-MM-yyyy")

    return today.format(date)

}
