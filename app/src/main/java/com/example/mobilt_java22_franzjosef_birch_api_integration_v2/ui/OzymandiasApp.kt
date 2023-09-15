package com.example.mobilt_java22_franzjosef_birch_api_integration_v2.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.enterAlwaysScrollBehavior
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.R
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.ui.screens.HomeScreen
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.ui.screens.OzymandiasViewModel
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.ui.screens.SplashScreen

enum class OzymandiasAppScreens(){
    Splash,
    Fact,
    Excuse
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OzymandiasApp(
    navController: NavHostController = rememberNavController(),
    ozymandiasViewModel: OzymandiasViewModel = viewModel(factory = OzymandiasViewModel.Factory)
) {
    val scrollBehaviour = enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehaviour.nestedScrollConnection),
        topBar = { FactAppBar(canNavigateBack = true , navigateUp = {}) }
    ){
     Surface(
         modifier = Modifier
             .fillMaxSize()
             .padding(it)
     ) {

         NavHost(navController,OzymandiasAppScreens.Splash.name, modifier = Modifier) {
             composable(route = OzymandiasAppScreens.Splash.name) {
                 SplashScreen(
                     onClickExcuses = {navController.navigate(OzymandiasAppScreens.Excuse.name)},
                     onClickFacts = { navController.navigate(OzymandiasAppScreens.Fact.name)},
                     )
             }
             composable(route = OzymandiasAppScreens.Fact.name) {
                 HomeScreen(
                     ozymandiasUiState = ozymandiasViewModel.uiState,
                     onClick = { ozymandiasViewModel.getRandomFact()},
                     buttonText = "Get Random"
                 )
             }
             composable(route = OzymandiasAppScreens.Excuse.name){
                 HomeScreen(
                     ozymandiasUiState = ozymandiasViewModel.uiState,
                     onClick = { ozymandiasViewModel.getRandomExcuse()},
                     buttonText = "Get Excuse" )
             }
         }


             /*
         HomeScreen(ozymandiasUiState = ozymandiasViewModel.uiState,buttonText = "Get Random", onClick = {ozymandiasViewModel.getRandom()})

              */
     }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FactAppBar(
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text("Hellu") },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}