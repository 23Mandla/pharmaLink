package com.example.pharmalink.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.pharmalink.ui.components.HeaderSection

@Composable
@Preview
fun MainPage(){
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

    ) {
        item { HeaderSection() }

    }
}