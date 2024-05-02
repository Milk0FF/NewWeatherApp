package com.example.newweatherapp.presentation.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newweatherapp.data.repository.WeatherData

@Composable
fun WeekWeatherList() {
    val weatherInfoList = remember { WeatherData.weatherInfoList }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 0.dp, vertical = 10.dp),
        modifier = Modifier.fillMaxHeight().fillMaxWidth()
    ) {
        items(
            items = weatherInfoList,
            itemContent = {
                WeekWeatherListItem(weatherInfo = it)
            })
    }
}

@Preview(showBackground = true)
@Composable
fun WeekWeatherListPreview(){
    WeekWeatherList()
}
