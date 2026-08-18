package com.inflame.Nutrihostel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import com.inflame.Nutrihostel.presentation.navigation.NutriHostelNavGraph
import com.inflame.Nutrihostel.presentation.theme.NutriHostelTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NutriHostelTheme {
                val navController = rememberNavController()
                NutriHostelNavGraph(navController = navController)
            }
        }
    }
}
