package com.inflame.Nutrihostel.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.inflame.Nutrihostel.presentation.Auth.LoginScreen
import com.inflame.Nutrihostel.presentation.Auth.RegisterScreen
import com.inflame.Nutrihostel.presentation.physicalprofile.HealthData1
import com.inflame.Nutrihostel.presentation.physicalprofile.HealthData2
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
                onRegisterClick ={
                    navController.navigate(Routes.RegisterScreen)
                }

            )
        }

        composable<Routes.RegisterScreen> {
            RegisterScreen(
                onSignUpClick ={
                    navController.navigate(Routes.HealthData1)
                }

            )
        }

        composable < Routes.HealthData1>{
            HealthData1(
                onNextClick = {
                    navController.navigate(Routes.HealthData2)
                },
                onBackClick = {
                    navController.navigate(Routes.LoginScreen)
                }
            )
        }

        composable<Routes.HealthData2> {
            HealthData2(
                onBackClick = {
                    navController.navigate(Routes.HealthData1)
                }

            )
        }
    }
}