package com.inflame.Nutrihostel.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.inflame.Nutrihostel.R
import com.inflame.Nutrihostel.presentation.theme.NutriBackground
import com.inflame.Nutrihostel.presentation.theme.NutriGreen
import com.inflame.Nutrihostel.presentation.theme.NutriTextPrimary
import com.inflame.Nutrihostel.presentation.theme.RoleStudentBg
import kotlinx.coroutines.delay

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    Splash(onNavigateToNext = { })
}

@Composable
fun Splash(
    modifier: Modifier = Modifier,
    onNavigateToNext: () -> Unit
) {
    LaunchedEffect(key1 = true) {
        delay(3000L)
        onNavigateToNext()
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(RoleStudentBg, NutriBackground)
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                modifier = Modifier.size(120.dp),
                shape = RoundedCornerShape(28.dp),
                color = Color.White,
                shadowElevation = 2.dp
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Logo",
                        modifier = Modifier.size(80.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "NutriHostel",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = NutriGreen
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Smart Meal Planning & Nutrition",
                style = MaterialTheme.typography.bodyLarge,
                color = NutriTextPrimary
            )
        }
    }
}
