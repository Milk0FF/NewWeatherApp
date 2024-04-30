package com.example.newweatherapp.data.repository

import android.content.Context
import android.widget.Toast
import com.example.newweatherapp.data.remote.WeatherApi
import com.google.gson.JsonObject
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun getWeatherInfoData(
    ctx: Context,
) {
    var url = "https://api.openweathermap.org"

    val interceptor = HttpLoggingInterceptor()
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    var client =  OkHttpClient.Builder().addInterceptor(interceptor).build()
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val retrofitAPI = retrofit.create(WeatherApi::class.java)

    val call: Call<JsonObject> = retrofitAPI.getWeather("55", "73.4", "metric")

    call!!.enqueue(object : Callback<JsonObject?> {
        override fun onResponse(call: Call<JsonObject?>?, response: Response<JsonObject?>) {
            if(response.isSuccessful()){
                val jsonWeather: JSONObject? = JSONObject(response.body().toString())
                val lon = jsonWeather?.getJSONObject("coord")?.getString("lon")
                val lat = jsonWeather?.getJSONObject("coord")?.getString("lat")
                val name = jsonWeather?.getString("name")
                val country = jsonWeather?.getJSONObject("sys")?.getString("country")

                Toast.makeText(ctx,"Data: ${lon} + ${lat} + ${name} + ${country}" , Toast.LENGTH_SHORT).show()

            }

        }


        override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
        }
    })

}