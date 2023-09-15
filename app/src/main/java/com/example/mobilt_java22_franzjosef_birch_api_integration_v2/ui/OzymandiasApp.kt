package com.example.mobilt_java22_franzjosef_birch_api_integration_v2.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
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
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.R
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.ui.screens.HomeScreen
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.ui.screens.OzymandiasViewModel
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.ui.screens.OptionsScreen
import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.ui.screens.SplashScreen

enum class OzymandiasAppScreens(@StringRes val title: Int){
    Splash(title = R.string.welcome),
    Options(title = R.string.make_your_selection),
    Fact(title = R.string.useless_facts),
    Excuse(title = R.string.what_s_your_excuse)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OzymandiasApp(
    navController: NavHostController = rememberNavController(),
    ozymandiasViewModel: OzymandiasViewModel = viewModel(factory = OzymandiasViewModel.Factory)
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val scrollBehaviour = enterAlwaysScrollBehavior()
    val currentScreen = OzymandiasAppScreens.valueOf(backStackEntry?.destination?.route ?: OzymandiasAppScreens.Splash.name)
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehaviour.nestedScrollConnection),
        topBar = { OzymandiasAppBar(currentScreen = currentScreen, canNavigateBack = navController.previousBackStackEntry != null, navigateUp = {navController.navigateUp()}, ) },
    floatingActionButton = { OzymandiasFloatingCloseButton(navController = navController, canNavigateBack = navController.previousBackStackEntry != null ) }
    ){
     Surface(
         modifier = Modifier
             .fillMaxSize()
             .padding(it)
     ) {

         NavHost(navController,OzymandiasAppScreens.Splash.name, modifier = Modifier) {
             composable(route = OzymandiasAppScreens.Splash.name){
                 SplashScreen(
                     onWelcomeClick = {navController.navigate(OzymandiasAppScreens.Options.name)},
                     )

             }
             composable(route = OzymandiasAppScreens.Options.name) {
                 OptionsScreen(
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

     }

    }
}

fun goToBeginning(
    navController: NavHostController
){
    navController.popBackStack(OzymandiasAppScreens.Splash.name, inclusive = false)
}

@Composable
fun OzymandiasFloatingCloseButton(navController: NavHostController, canNavigateBack: Boolean){
    if(canNavigateBack) {
        FloatingActionButton(
            onClick = { goToBeginning(navController) }
        ) {
            Icon(Icons.Default.Close, contentDescription = "Close")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OzymandiasAppBar(
    currentScreen: OzymandiasAppScreens,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(id = currentScreen.title)) },
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