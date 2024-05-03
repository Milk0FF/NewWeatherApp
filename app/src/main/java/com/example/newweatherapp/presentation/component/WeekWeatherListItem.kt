package com.example.newweatherapp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newweatherapp.R
import com.example.newweatherapp.data.repository.WeatherData
import com.example.newweatherapp.domain.model.WeatherInfo

@Composable
fun WeekWeatherListItem(weatherInfo: WeatherInfo) {
    Row (Modifier.padding(0.dp, 0.dp, 0.dp, 10.dp), verticalAlignment = Alignment.CenterVertically){
        Column(Modifier.weight(1f), horizontalAlignment = Alignment.End) {
                Row(verticalAlignment = Alignment.CenterVertically){
                    Text("${weatherInfo.humidity}%", fontSize = 25.sp,  textAlign = TextAlign.Center)
                    Image(
                        painter = painterResource(id = R.drawable.ic_sun),
                        contentDescription = "Sun",
                        modifier = Modifier
                            .size(50.dp)
                            .padding(10.dp, 0.dp, 0.dp, 0.dp),
                        colorFilter = ColorFilter.tint(Color.Yellow)
                    )
                }
        }
        Column(Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally){
            Text("WED")
            Text("${weatherInfo.date}")
        }
        Column(Modifier.weight(1f), horizontalAlignment = Alignment.Start){
            Text("Current : ${weatherInfo.minTemp}°",  textAlign = TextAlign.Center,fontSize = 15.sp)
            Text("Max : ${weatherInfo.maxTemp}°",  textAlign = TextAlign.Center, fontSize = 15.sp)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun WeekWeatherListItemPreview(){
    val weatherInfo = remember { WeatherData.weatherInfoList[0] }
    WeekWeatherListItem(weatherInfo)
}