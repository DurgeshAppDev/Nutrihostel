package com.inflame.Nutrihostel.navigation

import kotlinx.serialization.Serializable

sealed interface Routes {

    @Serializable
    data object Splash : Routes

    @Serializable
    data object LoginScreen : Routes

    @Serializable
    data object RegisterScreen : Routes

    @Serializable
    data object HealthData1: Routes

    @Serializable
    data object HealthData2 : Routes

    @Serializable
    data object  HomeScreen: Routes

    @Serializable
    data object  ProfileScreen : Routes

    @Serializable
    data object  MealsScreen: Routes

}