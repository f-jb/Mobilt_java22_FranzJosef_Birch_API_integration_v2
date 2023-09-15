package com.example.mobilt_java22_franzjosef_birch_api_integration_v2.network

import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.model.Fact
import retrofit2.http.GET

interface FactApiService{
    @GET("random")
    suspend fun getRandom(): Fact

    @GET("today")
    suspend fun getToday(): Fact

}
