package com.example.newweatherapp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newweatherapp.R
import com.example.newweatherapp.data.repository.WeatherData
import com.example.newweatherapp.domain.model.WeatherInfo

@Composable
fun WeatherListItem(weatherInfo: WeatherInfo) {

    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .width(200.dp),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
    ) {
        Row {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)) {

                Image(
                    painter = painterResource(id = R.drawable.ic_sun),
                    contentDescription = "Sun",
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.CenterHorizontally),
                    colorFilter = ColorFilter.tint(Color.Yellow)
                )

                Text(text = "${weatherInfo.temp}°",fontSize = 30.sp)
                Text(text = "Feels like ${weatherInfo.feelsLike}°", fontSize = 25.sp)
                Text(text = "${weatherInfo.time}", fontSize = 20.sp, modifier = Modifier.align(Alignment.End))
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun WeatherListItemPreview(){
    val weatherInfo = remember { WeatherData.weatherInfoList[0] }
    WeatherListItem(weatherInfo)
}