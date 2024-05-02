package com.example.newweatherapp.data.repository

import com.example.newweatherapp.domain.model.WeatherInfo

object WeatherData {
    val weatherInfoList = listOf(
        WeatherInfo(
            time = "10:00",
            date = "01.05.24",
            temp = "18",
            minTemp = "10",
            maxTemp = "10",
            feelsLike = "20",
            pressure= "Monty enjoys chicken treats and cuddling while watching Seinfeld.",
            humidity = "20"
        ),
        WeatherInfo(
            time = "13:00",
            date = "01.05.24",
            temp = "22",
            minTemp = "10",
            maxTemp = "10",
            feelsLike = "24",
            pressure= "Monty enjoys chicken treats and cuddling while watching Seinfeld.",
            humidity = "20"
        ),

        WeatherInfo(
            time = "16:00",
            date = "01.05.24",
            temp = "24",
            minTemp = "10",
            maxTemp = "10",
            feelsLike = "25",
            pressure= "Monty enjoys chicken treats and cuddling while watching Seinfeld.",
            humidity = "20"
        ),

        WeatherInfo(
            time = "19:00",
            date = "01.05.24",
            temp = "26",
            minTemp = "10",
            maxTemp = "10",
            feelsLike = "26",
            pressure= "Monty enjoys chicken treats and cuddling while watching Seinfeld.",
            humidity = "20"
        ),

        WeatherInfo(
            time = "22:00",
            date = "01.05.24",
            temp = "20",
            minTemp = "10",
            maxTemp = "10",
            feelsLike = "20",
            pressure= "Monty enjoys chicken treats and cuddling while watching Seinfeld.",
            humidity = "20"
        ),
    )
}