package com.example.newweatherapp.domain.model

data class WeatherInfo (
    val time: String?,
    val date: String?,
    val temp: String?,
    val minTemp: String?,
    val maxTemp: String?,
    val feelsLike: String?,
    val pressure: String?,
    val humidity: String?,
)