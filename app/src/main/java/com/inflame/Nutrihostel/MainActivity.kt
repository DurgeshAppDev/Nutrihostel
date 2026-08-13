package com.inflame.Nutrihostel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.inflame.Nutrihostel.presentation.role.RoleSelection
import com.inflame.Nutrihostel.presentation.splash.SplashScreen
import com.inflame.Nutrihostel.presentation.theme.NutriHostelTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NutriHostelTheme {
                var currentScreen by remember { mutableStateOf("splash") }

                when (currentScreen) {
                    "splash" -> {
                        SplashScreen(onNavigateToNext = {
                            currentScreen = "role_selection"
                        })
                    }
                    "role_selection" -> {
                        RoleSelection()
                    }
                }
            }
        }
    }
}
