package com.example.mobilt_java22_franzjosef_birch_api_integration_v2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.ui.OzymandiasApp
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.ui.theme.Mobilt_java22_FranzJosef_Birch_API_integration_v2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mobilt_java22_FranzJosef_Birch_API_integration_v2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    OzymandiasApp()

                }
            }
        }
    }
}