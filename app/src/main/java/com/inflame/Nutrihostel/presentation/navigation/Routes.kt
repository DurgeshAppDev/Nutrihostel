package com.inflame.Nutrihostel.presentation.navigation

import kotlinx.serialization.Serializable

sealed interface Routes {

    @Serializable
    data object Splash : Routes

    @Serializable
    data object RoleSelection : Routes

}