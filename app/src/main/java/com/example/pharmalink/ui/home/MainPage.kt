package com.example.pharmalink.ui.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.pharmalink.ui.components.HeaderSection
import com.example.pharmalink.ui.components.MedSection
import com.example.pharmalink.ui.components.MedsHeader

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainPage(bool: Boolean) {

    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

    ) {
        item { HeaderSection() }
        item { MedsHeader() }
        item { MedSection() }

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, apiLevel = 33)
@Composable
fun PreviewMainPage() {
    MainPage(false)
}