package com.example.mobilt_java22_franzjosef_birch_api_integration_v2.ui.screens

import android.app.Fragment
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.model.ResultToShow


@Composable
fun ResultScreen(result: ResultToShow, modifier: Modifier, onClick: () -> Unit, buttonText: String) {

    Column(
        modifier = modifier,
                verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Text(result.label, modifier.padding(bottom = 16.dp),textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
        Text(result.text, modifier.padding(horizontal = 32.dp,vertical = 32.dp))
        Button(
            modifier = modifier.padding(horizontal = 8.dp),
            onClick = onClick
        ){
            Text(buttonText)

        }
    }


}