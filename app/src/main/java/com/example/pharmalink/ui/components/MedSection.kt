package com.example.pharmalink.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.*
import androidx.navigation.NavHostController
import com.example.pharmalink.data.dataclass.Medication

@Composable
fun MedSection(
    medications: List<Medication> = emptyList(),
    navController: NavHostController? = null,
    onMedClick: (Medication) -> Unit = {}
){
    val context = LocalContext.current

    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // Adaptive
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .height(500.dp)
    ) {

        items(medications) { medication ->
            MedCard(
                context = context,
                medication = medication,
                onClick = {
                    if (navController != null) {
                        navController.navigate("medicationPage")
                        onMedClick(medication)
                    }
                }
            )
        }
    }
}
