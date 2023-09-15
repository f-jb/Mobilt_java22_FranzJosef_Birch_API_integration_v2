package com.example.mobilt_java22_franzjosef_birch_api_integration_v2.data

import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.network.ExcuseApiService
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.network.FactApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val factRepository: FactRepository
    val excuseRepository: ExcuseRepository
}


class DefaultAppContainer: AppContainer{
    private val excuseBaseUrl =
    "https://excuser-three.vercel.app/v1/excuse/"
    private val excuseRetrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(excuseBaseUrl)
        .build()

    private val excuseRetrofitService: ExcuseApiService by lazy {
        excuseRetrofit.create(ExcuseApiService::class.java)
    }
    override val excuseRepository: ExcuseRepository by lazy {
        NetworkExcuseRepository(excuseRetrofitService)
    }


    private val factBaseUrl =
        "https://uselessfacts.jsph.pl/api/v2/facts/"
    private val factRetrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(factBaseUrl)
        .build()

    private val factRetrofitService: FactApiService by lazy {
        factRetrofit.create(FactApiService::class.java)
    }
    override val factRepository: FactRepository by lazy {
        NetworkFactRepository(factRetrofitService)
    }

}
