package com.inflame.Nutrihostel.presentation.physicalprofile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.TrendingDown
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.MedicalInformation
import androidx.compose.material.icons.filled.Scale
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.Restaurant
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.inflame.Nutrihostel.presentation.theme.NutriDivider
import com.inflame.Nutrihostel.presentation.theme.NutriGreen
import com.inflame.Nutrihostel.presentation.theme.NutriGreenDark
import com.inflame.Nutrihostel.presentation.theme.NutriHostelTheme
import com.inflame.Nutrihostel.presentation.theme.NutriTextPrimary
import com.inflame.Nutrihostel.presentation.theme.NutriTextSecondary
import com.inflame.Nutrihostel.presentation.theme.RoleStudentBg

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HealthData2Preview() {
    NutriHostelTheme {
        HealthData2(onBackClick = {})
    }
}

@Composable
fun HealthData2(
    onBackClick: () -> Unit
) {
    var selectedGoal by remember { mutableStateOf("Maintain") }
    var selectedDiet by remember { mutableStateOf("Vegetarian") }
    var allergies by remember { mutableStateOf("") }
    var medicalConditions by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(RoleStudentBg, Color.White)
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Health & Diet",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = NutriTextPrimary
                )
                Text(
                    text = "2 of 2",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = NutriGreenDark
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Progress Bar
            LinearProgressIndicator(
                progress = { 0.95f },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp),
                color = NutriGreenDark,
                trackColor = NutriDivider,
                strokeCap = androidx.compose.ui.graphics.StrokeCap.Round
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Personalize your meal plan for optimal health.",
                style = MaterialTheme.typography.bodyMedium,
                color = NutriTextSecondary
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Fitness Goal Section
            Text(
                text = "Fitness Goal",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = NutriTextPrimary
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                GoalItem(
                    title = "Weight Loss",
                    icon = Icons.AutoMirrored.Filled.TrendingDown,
                    isSelected = selectedGoal == "Weight Loss",
                    modifier = Modifier.weight(1f),
                    onClick = { selectedGoal = "Weight Loss" }
                )
                GoalItem(
                    title = "Maintain",
                    icon = Icons.Default.Scale,
                    isSelected = selectedGoal == "Maintain",
                    modifier = Modifier.weight(1f),
                    onClick = { selectedGoal = "Maintain" }
                )
                GoalItem(
                    title = "Muscle Gain",
                    icon = Icons.AutoMirrored.Filled.TrendingUp,
                    isSelected = selectedGoal == "Muscle Gain",
                    modifier = Modifier.weight(1f),
                    onClick = { selectedGoal = "Muscle Gain" }
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Dietary Preference Section
            Text(
                text = "Dietary Preference",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = NutriTextPrimary
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(NutriDivider.copy(alpha = 0.3f), RoundedCornerShape(24.dp))
                    .padding(4.dp)
            ) {
                DietOption(
                    title = "Vegetarian",
                    icon = Icons.Outlined.Restaurant,
                    isSelected = selectedDiet == "Vegetarian",
                    modifier = Modifier.weight(1f),
                    onClick = { selectedDiet = "Vegetarian" }
                )
                DietOption(
                    title = "Non-Vegetarian",
                    icon = Icons.Outlined.Restaurant,
                    isSelected = selectedDiet == "Non-Vegetarian",
                    modifier = Modifier.weight(1f),
                    onClick = { selectedDiet = "Non-Vegetarian" }
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Medical & Allergies Section
            Text(
                text = "Medical & Allergies",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = NutriTextPrimary
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = allergies,
                onValueChange = { allergies = it },
                label = { Text("Allergies (Optional)") },
                placeholder = { Text("Food Allergies (e.g. Peanuts, Dairy)") },
                leadingIcon = { Icon(Icons.Default.Warning, contentDescription = null) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = NutriGreen,
                    unfocusedBorderColor = NutriTextSecondary.copy(alpha = 0.5f)
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = medicalConditions,
                onValueChange = { medicalConditions = it },
                label = { Text("Medical Info (Optional)") },
                placeholder = { Text("Medical Conditions (e.g. Diabetes)") },
                leadingIcon = { Icon(Icons.Default.MedicalInformation, contentDescription = null) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = NutriGreen,
                    unfocusedBorderColor = NutriTextSecondary.copy(alpha = 0.5f)
                )
            )

            Spacer(modifier = Modifier.weight(1f))

            // Bottom Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(
                    onClick = { onBackClick() },
                    modifier = Modifier
                        .weight(1f)
                        .height(56.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = NutriDivider.copy(alpha = 0.5f),
                        contentColor = NutriTextPrimary
                    )
                ) {
                    Text("Back", style = MaterialTheme.typography.titleMedium)
                }

                Button(
                    onClick = {  },
                    modifier = Modifier
                        .weight(1f)
                        .height(56.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = NutriGreen
                    )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("Finish", style = MaterialTheme.typography.labelLarge, lineHeight = 14.sp)
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(Icons.Default.CheckCircle, contentDescription = null)
                    }
                }
            }
        }
    }
}

@Composable
fun GoalItem(
    title: String,
    icon: ImageVector,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .background(
                if (isSelected) NutriGreen else NutriDivider.copy(alpha = 0.2f),
                RoundedCornerShape(24.dp)
            )
            .clickable { onClick() }
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = if (isSelected) Color.White else NutriTextPrimary,
            modifier = Modifier.size(32.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Bold,
            color = if (isSelected) Color.White else NutriTextPrimary,
            fontSize = 10.sp
        )
    }
}

@Composable
fun DietOption(
    title: String,
    icon: ImageVector,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .background(
                if (isSelected) Color.White else Color.Transparent,
                RoundedCornerShape(20.dp)
            )
            .clickable { onClick() }
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = if (isSelected) NutriGreenDark else NutriTextSecondary,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            color = if (isSelected) NutriGreenDark else NutriTextSecondary
        )
    }
}


