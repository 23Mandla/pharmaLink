package com.example.pharmalink.ui.medication

import android.content.res.Resources
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pharmalink.R

@Composable
@Preview
fun MedicationPage(onSendMessage : (String) -> Unit = {}){
    var message by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .background(colorResource(R.color.lighterNavy)),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Medication Page",
                color = Color.Black,
                modifier = Modifier
                    .padding(16.dp),
                maxLines = 1,
                fontSize = 22.sp
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = message,
                onValueChange = {
                    message = it
                },
                label = { Text("Search") }
            )

            IconButton(
                onClick = {
                    onSendMessage(message)
                    message = ""
                }
            ) {
                Icon(
                    painter = painterResource(R.drawable.baseline_send_24),
                    contentDescription = "Search"
                )
            }
        }
    }
}