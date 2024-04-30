package com.example.newweatherapp.data.remote

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("data/2.5/weather?appid=c80ea20764a8eae675a7fe923e9f5274")
    fun getWeather(
        @Query("lat") lat: String?,
        @Query("lon") lon: String?,
        @Query("units") units: String?
    ): Call<JsonObject>

    @GET("data/2.5/forecast?appid=c80ea20764a8eae675a7fe923e9f5274")
    fun getForecast(
        @Query("lat") lat: String?,
        @Query("lon") lon: String?,
        @Query("units") units: String?
    ): Call<JsonObject>
}