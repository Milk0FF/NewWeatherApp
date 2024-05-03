package com.example.newweatherapp.presentation.forecast_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newweatherapp.R
import com.example.newweatherapp.data.repository.WeatherData
import com.example.newweatherapp.data.repository.getWeatherInfoData
import com.example.newweatherapp.presentation.component.WeatherListItem
import com.example.newweatherapp.presentation.component.WeekWeatherListItem


@Composable
fun Forecast(){
    var value by remember { mutableStateOf("") }
    val ctx = LocalContext.current
    val weatherInfoList = remember { WeatherData.weatherInfoList }
    LazyColumn (Modifier.padding(10.dp)) {
        item{
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ){
                TextField(
                    value = value,
                    onValueChange = {value = it},
                    placeholder = { Text("Type city name") },
                    textStyle = TextStyle(fontSize=18.sp),
                    singleLine = false,
                    modifier = Modifier.weight(2f)
                )
                Button(
                    onClick = {
                        getWeatherInfoData(
                            ctx
                        )
                    },
                    modifier = Modifier
                        .padding(16.dp, 0.dp, 0.dp, 0.dp)
                        .weight(1f)


                ) {
                    Text(text = "Get \n weather", modifier = Modifier.padding(2.dp), textAlign = TextAlign.Center, fontSize = 12.sp)
                }
            }
        }
        item{
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "OMSK: Right now", fontSize = 25.sp)
            Text(text = "Right now")
            Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                Image(
                    painter = painterResource(id = R.drawable.ic_sun),
                    contentDescription = "Sun",
                    modifier = Modifier.size(100.dp),
                    colorFilter = ColorFilter.tint(Color.Yellow)
                )
                Spacer(modifier = Modifier.width(15.dp))
                Column {
                    Text(text = "22°",fontSize = 45.sp)
                    Text(text = "Feels like 22°", fontSize = 25.sp)
                }
            }
            Spacer(modifier = Modifier.height(10.dp))


            Text(text = "This afternoon",fontSize = 25.sp)
            Text(text = "Sunny",fontSize = 15.sp)
        }

        item {
            LazyRow(Modifier.fillMaxWidth()) {
                items(
                    items = weatherInfoList,
                    itemContent = {
                        WeatherListItem(weatherInfo = it)
                    })
            }
        }

        item{
            Text(text = "This week",fontSize = 25.sp)

            Text(text = "Sunny today and later in week with",fontSize = 15.sp, modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 15.dp))
        }
        items(
            items = weatherInfoList,
            itemContent = {
                WeekWeatherListItem(weatherInfo = it)
            })
   }
}
@Preview(showBackground = true)
@Composable
fun ForecastPreview() {
    Forecast ()
}
