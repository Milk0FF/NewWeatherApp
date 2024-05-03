package com.example.newweatherapp.presentation.settings_screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.example.newweatherapp.R
import com.example.newweatherapp.data.repository.WeatherData
import com.example.newweatherapp.presentation.component.DropdownComponent
import com.example.newweatherapp.presentation.component.WeatherListItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Settings(){
    val context = LocalContext.current
    val dataSource = arrayOf( "International", "USA", "UK", "Canada")
    val windSpeeds = arrayOf( "M/S", "Knots", "Beaufort")
    val barometricPressures = arrayOf( "Millibars(mb)", "Mercury (mmHg)", "Mercury (inHg)", "Hectopascals (hPa)", "Kilopascals (kPa)")

    Column( Modifier.fillMaxWidth()){
        Row(Modifier.padding(10.dp)){
            Text("Settings ", fontSize = 30.sp)
        }
        Column(Modifier.padding(10.dp, 5.dp)) {
            Text("WEATHER UNITS", fontSize = 20.sp, modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 10.dp))

            DropdownComponent(ctx = context, items = dataSource, defaultIndex = 3 , label = "Data Source" )
            val checkedState = remember { mutableStateOf(false) }
            val textColor = remember { mutableStateOf(Color.Unspecified) }
            Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 10.dp)) {
                Text("24-Hour Time", fontSize = 15.sp, modifier = Modifier.weight(1f))
                Switch(
                    checked = checkedState.value,
                    onCheckedChange = {
                        checkedState.value = it
                        if(checkedState.value) textColor.value = Color(0xFFC62828)
                        else textColor.value = Color.Unspecified
                    },
                )
            }
            DropdownComponent(ctx = context, items = windSpeeds, defaultIndex = 0 , label = "Wind Speed" )

            DropdownComponent(ctx = context, items = barometricPressures, defaultIndex = 0 , label = "Barometric Pressure" )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsPreview(){
    Settings()
}