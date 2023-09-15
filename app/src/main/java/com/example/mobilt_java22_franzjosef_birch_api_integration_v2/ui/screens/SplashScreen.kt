package com.example.mobilt_java22_franzjosef_birch_api_integration_v2.ui.screens

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SplashScreen(onWelcomeClick: () -> Unit) {
   Button(onClick = onWelcomeClick){
       Text("Welcome")
   }

}