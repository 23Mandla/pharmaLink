package com.example.pharmalink.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.pharmalink.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    scrollBehavior: TopAppBarScrollBehavior,
) {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 0.dp)
            ) {

                Image(
                    painter = painterResource(R.drawable.profile),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .padding(end = 8.dp, start = 0.dp)
                        .clip(CircleShape)
                        .size(65.dp) //TODO automatically adjust size
                        .clickable(
                            onClick = { /*TODO navigate back home*/ }
                        )
                )

                Text(
                    "Dlamini",
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(1f),
                    fontSize = 17.sp,
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .testTag("userName")
                )
            }
        },
        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(0.4f)
        ),
        actions = {
            Icon(
                painter = painterResource(R.drawable.baseline_notifications_24),
                contentDescription = "Notifications",
                modifier = Modifier
                    .padding(end = 20.dp)
                    .clickable(
                        onClick = { /*TODO navigate to notifications*/ }
                    )
            )
        }
    )
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
@Preview
fun TopBarPreview() {
    TopBar(
        scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    )
}