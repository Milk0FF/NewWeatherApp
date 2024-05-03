package com.example.newweatherapp.presentation.radar_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier

@Composable
fun Radar(){
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()){
        Text("Radar page is unavailable", fontSize = 30.sp, textAlign = TextAlign.Center)
    }
}