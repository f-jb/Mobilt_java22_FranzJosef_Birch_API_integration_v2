package com.example.mobilt_java22_franzjosef_birch_api_integration_v2

import android.app.Application
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.data.AppContainer
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.data.DefaultAppContainer

class OzymandiasApplication: Application() {
   lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}