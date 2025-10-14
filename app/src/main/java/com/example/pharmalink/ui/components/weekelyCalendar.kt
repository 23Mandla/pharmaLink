package com.example.pharmalink.ui.components

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun getTodayDay() : String{
    val today = LocalDate.now()
    return today.format(DateTimeFormatter.ofPattern("d"))
}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview
fun WeeklyCalendar() {
    // Get today's day
    val todayDay = getTodayDay()

    // display today month
    val daysOfTheWeek = getToday()
    Log.d("Weekday", daysOfTheWeek.toString())

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 13.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),

    ) {
        items(
            daysOfTheWeek
                .take(7)
        ) { (day, date) ->
            if (todayDay == date)
                WeekDayCard(
                    day = day,
                    date = date,
                    isToday = true
                )
            else {
                WeekDayCard(
                    day = day,
                    date = date,
                    isToday = false
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun getToday(): List<Pair<String, String>> {
    val today = LocalDate.now()
    val startWeek = today.with(DayOfWeek.MONDAY)
    val formatDay = DateTimeFormatter.ofPattern("EEE")
    val formatDate = DateTimeFormatter.ofPattern("d")

    //return seven days
    return (0..6).map { offset ->
        val day = startWeek.plusDays(offset.toLong())
        Pair(day.format(formatDay), day.format(formatDate))

    }
}