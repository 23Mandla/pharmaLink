package com.example.pharmalink

import android.os.*
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.pharmalink.navigation.AppNav
import com.example.pharmalink.ui.theme.PharmaLinkTheme

class MainActivity : ComponentActivity() {
    private var show = true
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        val splashScreen: SplashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition { show }
        Handler(Looper.getMainLooper()).postDelayed({
            show = false
        }, 2000)

        setContent {
            PharmaLinkTheme {
                AppNav()
            }
        }
    }
}