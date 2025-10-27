package com.example.pharmalink.utils.bottomNav

import androidx.annotation.DrawableRes

data class NavItems(
    val label: String,
    val route: String? = null,
    @DrawableRes val icon: Int,
)
