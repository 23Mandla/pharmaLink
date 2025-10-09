package com.example.pharmalink.ui.home

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.pharmalink.data.repository.MedicationImpl
import com.example.pharmalink.data.retroClient.InternetService
import com.example.pharmalink.data.viewmodel.MedicationViewModel
import com.example.pharmalink.data.viewmodel.ViewModelFactory
import com.example.pharmalink.ui.components.HeaderSection
import com.example.pharmalink.ui.components.MedSection
import com.example.pharmalink.ui.components.MedsHeader

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainPage(
    bool: Boolean,
    navController: NavHostController? = null
    ) {

    val repository = MedicationImpl(
        apiService = InternetService.medicationApiService,
        mapper = InternetService.medicationMapper
    )

    // view model factory ? with data injection
    val factory = ViewModelFactory(repository)

    val viewModel : MedicationViewModel = viewModel(factory = factory)

    val medicationState = viewModel.medicationState.collectAsStateWithLifecycle()
    Log.d("MedicationState", medicationState.value.toString())

    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

    ) {
        item { HeaderSection() }
        item { MedsHeader() }
        item { MedSection(
            medicationState.value.medication,
            navController = navController
            )
        }

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, apiLevel = 33)
@Composable
fun PreviewMainPage() {
    MainPage(
        false,
        navController = NavHostController(LocalContext.current))
}