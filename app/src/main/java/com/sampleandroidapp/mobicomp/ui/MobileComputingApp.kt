package com.sampleandroidapp.mobicomp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sampleandroidapp.mobicomp.MobileComputingAppState
import com.sampleandroidapp.mobicomp.rememberMobileComputingAppState
import com.sampleandroidapp.mobicomp.ui.home.Home
import com.sampleandroidapp.mobicomp.ui.login.LoginScreen
import com.sampleandroidapp.mobicomp.ui.profile.Profile
import com.sampleandroidapp.mobicomp.ui.reminder.Reminder

@Composable
fun MobileComputingApp(
    appState: MobileComputingAppState = rememberMobileComputingAppState()
) {
    NavHost(
        navController = appState.navController,
        startDestination = "login"              // app start destination is login package
    ) {
        composable(route = "home") {
            Home(navController = appState.navController)
        }
        composable(route = "login") {
            LoginScreen(navController = appState.navController)
        }
        composable(route = "profile") {
            Profile(navController = appState.navController)
        }
        composable(route = "reminder") {
            Reminder(onBackPress = appState::navigateBack)
        }
    }
}