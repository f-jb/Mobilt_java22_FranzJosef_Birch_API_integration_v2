package com.example.mobilt_java22_franzjosef_birch_api_integration_v2

import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.data.NetworkFactRepository
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.fake.FakeDataSource
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.fake.FakeFactApiService
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkFactRepositoryTest {
    @Test
    fun networkFactRepository_getToday_verifyFact() =
        runTest{
            val expectedFact = FakeDataSource.fact
            val repository = NetworkFactRepository(
                factApiService = FakeFactApiService()
            )
            assertEquals(expectedFact, repository.getToday())
        }
    @Test
    fun networkFactRepository_getRandom_verifyFact() =
        runTest{
            val expectedFact = FakeDataSource.fact
            val repository = NetworkFactRepository(
                factApiService = FakeFactApiService()
            )
            assertEquals(expectedFact, repository.getRandom())
        }
}
