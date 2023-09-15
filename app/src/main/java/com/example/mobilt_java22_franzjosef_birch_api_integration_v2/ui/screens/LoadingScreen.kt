package com.example.mobilt_java22_franzjosef_birch_api_integration_v2.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.R.drawable.loading_img
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.R.string.loading


@Composable
fun LoadingScreen(modifier: Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(loading_img),
        contentDescription = stringResource(loading)
    )
}