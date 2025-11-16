package com.example.pharmalink.ui.components.medication_page

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.*
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.compose.ui.util.lerp
import com.example.pharmalink.R
import com.example.pharmalink.utils.aippGradientBackground

import kotlin.math.absoluteValue

@Composable
@Preview
fun MedicationPager(){

    // TODO call an api to display medication fdaGov
    val images = listOf(
        R.drawable.medication,
        R.drawable.panado_pack,
        R.drawable.panado_pill
    )
    val pagerState = rememberPagerState(
        pageCount = { images.size }
    )

    val fling = PagerDefaults.flingBehavior(
        state = pagerState,
        pagerSnapDistance = PagerSnapDistance.atMost(10)
    )

    val pagerIsDragged by pagerState.interactionSource.collectIsDraggedAsState()

    val pageInteractionSource = remember { MutableInteractionSource() }
    val pageIsPressed by pageInteractionSource.collectIsPressedAsState()

    // Stop auto-advancing when pager is dragged or one of the pages is pressed
    val autoAdvance = !pagerIsDragged && !pageIsPressed

    if(autoAdvance){
        LaunchedEffect(
            pagerState, pageInteractionSource
        ) {
            while (true) {
                pagerState.animateScrollToPage(
                    page = (pagerState.currentPage + 1) % (pagerState.pageCount),

                    animationSpec = tween(3000)
                )
            }
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalPager(
            state = pagerState,
            pageSize = PageSize.Fixed(78.dp),
            beyondViewportPageCount = 3,
            flingBehavior = fling
        ) {
            page ->
                Card(
                    Modifier
                        .size(70.dp)
                        .graphicsLayer {
                            // Calculate the absolute offset for the current page from the
                            // scroll position. We use the absolute value which allows us to mirror
                            // any effects for both directions
                            val pageOffset = (
                                    (pagerState.currentPage - page) + pagerState
                                        .currentPageOffsetFraction
                                    ).absoluteValue

                            // We animate the alpha, between 50% and 100%
                            alpha = lerp(
                                start = 0.5f,
                                stop = 1f,
                                fraction = 1f - pageOffset.coerceIn(0f, 1f)
                            )
                        }
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .aippGradientBackground(),

                        contentAlignment = Alignment.Center
                    ){
                        Image(

                            painter = painterResource(images[page]),
                            contentDescription = "Medication",
                            modifier = Modifier

                                .padding(10.dp)
                        )
                    }
                }

        }
    }
}