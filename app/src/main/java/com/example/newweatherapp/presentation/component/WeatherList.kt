package com.example.newweatherapp.presentation.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.example.newweatherapp.data.repository.WeatherData
import com.example.newweatherapp.presentation.component.WeatherListItem

@Composable
fun WeatherList() {
    val weatherInfoList = remember { WeatherData.weatherInfoList }
    LazyRow(
        contentPadding = PaddingValues(horizontal = 0.dp, vertical = 8.dp),
    ) {
        items(
            items = weatherInfoList,
            itemContent = {
                WeatherListItem(weatherInfo = it)
            })
    }
}