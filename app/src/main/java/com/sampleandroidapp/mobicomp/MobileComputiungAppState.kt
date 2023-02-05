package com.sampleandroidapp.mobicomp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


class MobileComputingAppState(
    val navController: NavHostController
) {
    fun navigateBack() {
        navController.popBackStack()   // remove last screen off from stack, go back to previous screen
    }
}

@Composable
fun rememberMobileComputingAppState(
    navController: NavHostController = rememberNavController()
) = remember(navController) {
    MobileComputingAppState(navController)
}