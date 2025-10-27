package com.example.pharmalink.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.pharmalink.R
import com.example.pharmalink.utils.bottomNav.NavItems

@Composable
@Preview
fun BottomBar(){

    val navItems = listOf(
        NavItems(
            label = "Home",
            route = "mainPage",
            icon = R.drawable.baseline_home_24
        ),

        NavItems(
            label = "Scan",
            route = "scanPage",
            icon = R.drawable.baseline_document_scanner_24
        ),

        NavItems(
            label = "Profile",
            route = "profilePage",
            icon = R.drawable.baseline_person_24
        )
    )

    var selectedInex by remember {
        mutableIntStateOf(0)
    }

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(0.4f)
    ) {
       navItems.forEachIndexed {
           index, items ->
           NavigationBarItem(
               selected = selectedInex == index,
               onClick = {
                   selectedInex = index
               },
               icon = {
                   Icon(
                       painter = painterResource(items.icon),
                       contentDescription = items.label
                   )
               },
               label = {
                   Text(
                       items.label
                   )
               }
           )
       }
    }
}