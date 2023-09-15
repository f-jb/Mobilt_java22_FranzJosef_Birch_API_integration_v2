package com.example.mobilt_java22_franzjosef_birch_api_integration_v2.network

import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.model.Excuse
import retrofit2.Call
import retrofit2.http.GET

interface ExcuseApiService {
    @GET("developers")
    suspend fun getRandomExcuse(): List<Excuse>
}
