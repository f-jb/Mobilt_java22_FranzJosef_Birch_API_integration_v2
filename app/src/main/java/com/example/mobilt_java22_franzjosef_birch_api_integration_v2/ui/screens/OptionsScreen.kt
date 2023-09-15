package com.example.mobilt_java22_franzjosef_birch_api_integration_v2.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.R

@Composable
fun OptionsScreen(onClickExcuses: () -> Unit, onClickFacts: () -> Unit ) {
   Column{
     Button(onClick = onClickFacts){ Text(stringResource(R.string.facts))}
       Button(onClick = onClickExcuses){Text(stringResource(R.string.excuse))}

   }
}