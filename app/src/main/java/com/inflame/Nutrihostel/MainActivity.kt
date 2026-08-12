package com.inflame.Nutrihostel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.inflame.Nutrihostel.presentation.splash.SplashScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SplashScreen(onNavigateToNext = {
                // TODO: Navigate to the next screen
            })
        }
    }
}
