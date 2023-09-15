package com.example.mobilt_java22_franzjosef_birch_api_integration_v2

import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.fake.FakeDataSource
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.fake.FakeNetworkFactRepository
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.rules.TestDispatcherRule
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.ui.screens.OzymandiasUiState
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.ui.screens.OzymandiasViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class OzymandiasViewModelTest {
    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun ozymandiasViewModel_getToday_verifyFactUiStateSuccess(){
        runTest {
            val ozymandiasViewModel = OzymandiasViewModel(
                factRepository = FakeNetworkFactRepository()
            )

            assertEquals(
                OzymandiasUiState.Success(FakeDataSource.fact), ozymandiasViewModel.uiState

            )
        }
    }
}