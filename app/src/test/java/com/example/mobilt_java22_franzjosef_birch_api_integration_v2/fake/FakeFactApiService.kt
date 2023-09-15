package com.example.mobilt_java22_franzjosef_birch_api_integration_v2.fake

import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.model.Fact
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.network.FactApiService

class FakeFactApiService: FactApiService {
    override suspend fun getRandom(): Fact {
        return FakeDataSource.fact
    }

    override suspend fun getToday(): Fact {
        return FakeDataSource.fact
    }

}