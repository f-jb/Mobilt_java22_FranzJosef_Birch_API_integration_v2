package com.example.mobilt_java22_franzjosef_birch_api_integration_v2.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.model.Fact


@Composable
fun HomeScreen(
    ozymandiasUiState: OzymandiasUiState,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    buttonText: String
) {
    when(ozymandiasUiState){
        is OzymandiasUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is OzymandiasUiState.Success -> ResultScreen(
            result = ozymandiasUiState.resultToShow,
            modifier = modifier.fillMaxWidth(),
            onClick = onClick,
            buttonText = buttonText,
        )
        is OzymandiasUiState.Error -> ErrorScreen ( modifier = modifier.fillMaxSize())
    }
}

