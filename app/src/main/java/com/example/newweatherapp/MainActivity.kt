package com.example.newweatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newweatherapp.presentation.BottomNavigationBar
import com.example.newweatherapp.presentation.NavRoutes
import com.example.newweatherapp.presentation.forecast_screen.Forecast
import com.example.newweatherapp.presentation.location_screen.Location
import com.example.newweatherapp.presentation.radar_screen.Radar
import com.example.newweatherapp.presentation.settings_screen.Settings
import com.example.newweatherapp.ui.theme.NewWeatherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewWeatherAppTheme {
                Surface(
                ) {
                    Main()
                }
            }
        }
    }
}
@Composable
fun Main() {
    val navController = rememberNavController()
    Column() {
        NavHost(navController, startDestination = NavRoutes.Forecast.route, modifier = Modifier.weight(1f)) {
            composable(NavRoutes.Location.route) { Location() }
            composable(NavRoutes.Forecast.route) { Forecast()  }
            composable(NavRoutes.Radar.route) { Radar() }
            composable(NavRoutes.Settings.route) { Settings() }
        }
        BottomNavigationBar(navController = navController)
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    Main ()
}