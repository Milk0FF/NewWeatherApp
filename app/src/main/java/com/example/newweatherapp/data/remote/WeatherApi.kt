package com.example.newweatherapp.data.remote

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    companion object {
        const val API_KEY = "c80ea20764a8eae675a7fe923e9f5274"
        const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    }

    @GET("weather")
    fun getWeather(
        @Query("q") cityName: String,
        @Query("units") units: String = "metric",
        @Query("appId") apiKey: String = API_KEY
    ): Call<JsonObject>

    @GET("forecast")
    fun getForecast(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("units") units: String = "metric",
        @Query("appId") apiKey: String = API_KEY
    ): Call<JsonObject>
}