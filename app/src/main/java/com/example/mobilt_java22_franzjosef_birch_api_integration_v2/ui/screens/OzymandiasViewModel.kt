package com.example.mobilt_java22_franzjosef_birch_api_integration_v2.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.OzymandiasApplication
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.data.ExcuseRepository
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.data.FactRepository
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.model.Excuse
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.model.Fact
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.model.ResultToShow
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface OzymandiasUiState{
    data class Success(val resultToShow: ResultToShow): OzymandiasUiState
    object Error: OzymandiasUiState
    object Loading : OzymandiasUiState
}
class OzymandiasViewModel(private val factRepository: FactRepository, private val excuseRepository: ExcuseRepository): ViewModel(){
    var uiState: OzymandiasUiState by mutableStateOf(OzymandiasUiState.Loading)
        private set


    init {
            getTodayFact()
    }
    fun getRandomExcuse(){
        viewModelScope.launch {
            uiState = try {
                val excuseResult: Excuse = excuseRepository.getRandomExcuse()
                OzymandiasUiState.Success(
                    ResultToShow(
                        label = "Excuse",
                        text = excuseResult.excuse
                    )
                )
            } catch (e: IOException){
                OzymandiasUiState.Error
            }
        }
    }

    fun getRandomFact(){
       viewModelScope.launch{
           uiState = try{
               val factResult: Fact = factRepository.getRandom()
               val typeOfFact: String = "Random"
               OzymandiasUiState.Success(
                   ResultToShow(
                       label = typeOfFact,
                       text = factResult.text
                   )
               )
           } catch (e: IOException){
               OzymandiasUiState.Error
           }
       }
    }

    fun getTodayFact() {
        viewModelScope.launch{
            uiState = try{
                val factResult: Fact = factRepository.getToday()
                val typeOfFact: String = "Today"
                OzymandiasUiState.Success(
                    ResultToShow(
                        label = typeOfFact,
                        text = factResult.text
                    )
                )
            } catch (e: IOException){
                OzymandiasUiState.Error
            }
        }
    }

    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as OzymandiasApplication)
                val factRepository = application.container.factRepository
                val excuseRepository = application.container.excuseRepository
                OzymandiasViewModel(factRepository = factRepository, excuseRepository = excuseRepository)
            }
        }
    }

}