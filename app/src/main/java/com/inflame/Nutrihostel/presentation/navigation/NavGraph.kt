package com.inflame.Nutrihostel.presentation.navigation

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.inflame.Nutrihostel.presentation.Auth.LoginScreen
import com.inflame.Nutrihostel.presentation.splash.Splash

@Composable
fun NutriHostelNavGraph(
    navController: NavHostController
) {
    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = Routes.Splash
    ) {

        composable<Routes.Splash> {
            Splash(
                onNavigateToNext = {
                    navController.navigate(Routes.LoginScreen) {
                        popUpTo(Routes.Splash) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable<Routes.LoginScreen> {
            LoginScreen(

            )
        }

//        composable<Routes.RegisterScreen> {
//            RegisterScreen(
//
//            )
//        }
    }
}