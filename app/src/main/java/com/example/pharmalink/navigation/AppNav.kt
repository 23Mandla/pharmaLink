package com.example.pharmalink.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pharmalink.R
import com.example.pharmalink.ui.components.TopBar
import com.example.pharmalink.ui.home.MainPage
import com.example.pharmalink.ui.login.Login
import com.example.pharmalink.ui.medication.MedicationPage

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNav(showTopBar : Boolean = true){
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = backStackEntry?.destination?.route

    Scaffold(
        containerColor = colorResource(R.color.white),
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        topBar = {
            if(currentScreen == "mainPage" && showTopBar){
                TopBar(
                    scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()

        ){
            NavHost(
                navController = navController,
                startDestination = "login",
                modifier = Modifier.fillMaxSize()
            ) {
                composable("login") {
                    Login(onClick = { navController.navigate("mainPage") })
                }
                composable("mainPage") {
                    MainPage(true, navController)
                }

                composable("medicationPage") {
                    MedicationPage()
                }
            }
        }
    }
}