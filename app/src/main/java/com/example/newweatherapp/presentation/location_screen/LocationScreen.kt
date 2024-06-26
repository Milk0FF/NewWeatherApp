package com.example.newweatherapp.presentation.location_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Location(){
    var value by remember { mutableStateOf("") }
    Column(Modifier.padding(10.dp)){
        TextField(
            value = value,
            onValueChange = {value = it},
            placeholder = { Text("Type city name") },
            textStyle = TextStyle(fontSize=18.sp),
            singleLine = false,
            modifier = Modifier.fillMaxWidth()
        )
        LazyColumn(){
            items(15){
                CityListItem()
            }
        }
    }
}
@Composable
fun CityListItem(){
    Column (Modifier.padding(15.dp, 10.dp).fillMaxWidth()) {
        Text("Omsk", fontSize = 15.sp)
        Text("Russia", fontSize = 10.sp)
    }
}
@Preview(showBackground = true)
@Composable
fun LocationPreview() {
    Location ()
}
