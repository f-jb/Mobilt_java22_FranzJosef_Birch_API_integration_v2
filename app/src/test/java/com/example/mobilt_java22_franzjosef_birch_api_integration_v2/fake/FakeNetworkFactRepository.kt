package com.example.mobilt_java22_franzjosef_birch_api_integration_v2.fake

import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.data.FactRepository
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.model.Fact

class FakeNetworkFactRepository : FactRepository{
    override suspend fun getRandom(): Fact {
        return FakeDataSource.fact
    }

    override suspend fun getToday(): Fact {
        return FakeDataSource.fact
    }
}