package com.example.mobilt_java22_franzjosef_birch_api_integration_v2.data

import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.model.Excuse
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.network.ExcuseApiService
import retrofit2.Response

interface ExcuseRepository {
    suspend fun getRandomExcuse(): Excuse
}


class NetworkExcuseRepository(
    private val excuseApiService: ExcuseApiService
): ExcuseRepository{
    override suspend fun getRandomExcuse(): Excuse =
        excuseApiService.getRandomExcuse()[0]

}
