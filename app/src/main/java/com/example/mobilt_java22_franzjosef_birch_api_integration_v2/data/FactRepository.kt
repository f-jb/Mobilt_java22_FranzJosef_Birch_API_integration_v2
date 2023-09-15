package com.example.mobilt_java22_franzjosef_birch_api_integration_v2.data

import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.model.Fact
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.network.FactApiService

interface FactRepository {
    suspend fun getToday(): Fact
    suspend fun getRandom(): Fact
}


class NetworkFactRepository(
    private val factApiService: FactApiService
): FactRepository{
    override suspend fun getRandom(): Fact = factApiService.getRandom()

    override suspend fun getToday(): Fact = factApiService.getToday()
}