package com.inflame.Nutrihostel.presentation.user

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.outlined.DirectionsRun
import androidx.compose.material.icons.outlined.Flag
import androidx.compose.material.icons.outlined.MedicalInformation
import androidx.compose.material.icons.outlined.Restaurant
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.inflame.Nutrihostel.presentation.theme.NutriBackground
import com.inflame.Nutrihostel.presentation.theme.NutriDivider
import com.inflame.Nutrihostel.presentation.theme.NutriGreen
import com.inflame.Nutrihostel.presentation.theme.NutriHostelTheme
import com.inflame.Nutrihostel.presentation.theme.NutriSurfaceBlue
import com.inflame.Nutrihostel.presentation.theme.NutriTextLight
import com.inflame.Nutrihostel.presentation.theme.NutriTextPrimary
import com.inflame.Nutrihostel.presentation.theme.NutriTextSecondary

@Preview(showBackground = true)
@Composable
fun DietaryPreferenceScreenPreview() {
    NutriHostelTheme {
        DietaryPreferenceScreen()
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun DietaryPreferenceScreen() {
    var fitnessGoal by remember { mutableStateOf("Maintain Weight") }
    var dietPreference by remember { mutableStateOf("Non-Vegetarian") }
    var activityLevel by remember { mutableStateOf("Lightly Active (Light Exercise)") }
    var selectedAllergy by remember { mutableStateOf("None") }
    var medicalConditions by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Health & Dietary Preferences",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {  }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )
            )
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Text(
                    text = "Changes will affect future AI nutrition recommendations only.",
                    style = MaterialTheme.typography.bodySmall,
                    color = NutriTextSecondary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    OutlinedButton(
                        onClick = {  },
                        modifier = Modifier.weight(1f).height(48.dp),
                        shape = RoundedCornerShape(24.dp),
                        border = androidx.compose.foundation.BorderStroke(1.dp, NutriGreen)
                    ) {
                        Text("Reset", color = NutriGreen, style = MaterialTheme.typography.labelLarge)
                    }
                    Button(
                        onClick = {  },
                        modifier = Modifier.weight(2f).height(48.dp),
                        shape = RoundedCornerShape(24.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = NutriGreen)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("Save Preferences", style = MaterialTheme.typography.labelLarge)
                            Spacer(modifier = Modifier.width(8.dp))
                            Icon(Icons.Default.CheckCircle, contentDescription = null, modifier = Modifier.size(18.dp))
                        }
                    }
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(NutriBackground)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Privacy Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = NutriSurfaceBlue),
                shape = RoundedCornerShape(16.dp)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(Color(0xFF2196F3), CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Default.Shield, contentDescription = null, tint = Color.White, modifier = Modifier.size(24.dp))
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(
                            text = "Your Privacy Matters",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF1565C0)
                        )
                        Text(
                            text = "These preferences are used exclusively to personalize your meal plans and AI nutrition recommendations.",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color(0xFF1976D2),
                            lineHeight = 16.sp
                        )
                    }
                }
            }

            // Fitness Goal Section
            PreferenceSection(
                title = "Fitness Goal",
                icon = Icons.Outlined.Flag
            ) {
                val goals = listOf("Maintain Weight", "Weight Loss", "Weight Gain", "Muscle Gain", "Healthy Lifestyle")
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    goals.forEach { goal ->
                        PreferenceChip(
                            text = goal,
                            isSelected = fitnessGoal == goal,
                            onClick = { fitnessGoal = goal }
                        )
                    }
                }
            }

            // Diet Preference Section
            PreferenceSection(
                title = "Diet Preference",
                icon = Icons.Outlined.Restaurant
            ) {
                val diets = listOf("Vegetarian", "Non-Vegetarian", "Vegan", "Eggetarian")
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    diets.forEach { diet ->
                        PreferenceChip(
                            text = diet,
                            isSelected = dietPreference == diet,
                            onClick = { dietPreference = diet }
                        )
                    }
                }
            }

            // Daily Activity Level Section
            PreferenceSection(
                title = "Daily Activity Level",
                icon = Icons.Outlined.DirectionsRun
            ) {
                OutlinedTextField(
                    value = activityLevel,
                    onValueChange = { activityLevel = it },
                    readOnly = true,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    trailingIcon = {
                        Icon(Icons.Default.KeyboardArrowDown, contentDescription = null)
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = Color(0xFFF5F5F5),
                        focusedContainerColor = Color(0xFFF5F5F5),
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = Color.Transparent
                    )
                )
            }

            // Food Allergies Section
            PreferenceSection(
                title = "Food Allergies",
                icon = Icons.Outlined.Warning
            ) {
                val allergies = listOf("Peanuts", "Milk", "Soy", "Eggs", "Gluten", "None")
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    allergies.forEach { allergy ->
                        PreferenceChip(
                            text = allergy,
                            isSelected = selectedAllergy == allergy,
                            onClick = { selectedAllergy = allergy }
                        )
                    }
                }
            }

            // Medical Conditions Section
            PreferenceSection(
                title = "Medical Conditions",
                subtitle = "(Optional)",
                icon = Icons.Outlined.MedicalInformation
            ) {
                OutlinedTextField(
                    value = medicalConditions,
                    onValueChange = { medicalConditions = it },
                    placeholder = {
                        Text(
                            "Example: Diabetes, High Blood Pressure",
                            style = MaterialTheme.typography.bodyMedium,
                            color = NutriTextLight
                        )
                    },
                    modifier = Modifier.fillMaxWidth().height(120.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = NutriDivider,
                        focusedBorderColor = NutriGreen
                    )
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Icon(
                        Icons.Default.Info,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = NutriTextSecondary
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        "Briefly describe any conditions the AI should consider.",
                        style = MaterialTheme.typography.bodySmall,
                        color = NutriTextSecondary
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun PreferenceSection(
    title: String,
    subtitle: String = "",
    icon: ImageVector,
    content: @Composable () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(icon, contentDescription = null, tint = NutriGreen, modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = NutriTextPrimary
                )
                if (subtitle.isNotEmpty()) {
                    Text(
                        text = " $subtitle",
                        style = MaterialTheme.typography.bodySmall,
                        color = NutriTextSecondary
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            content()
        }
    }
}

@Composable
fun PreferenceChip(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(if (isSelected) NutriGreen else Color(0xFFF5F5F5))
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (isSelected) {
                Icon(
                    Icons.Default.Check,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
            }
            Text(
                text = text,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                color = if (isSelected) Color.White else NutriTextSecondary
            )
        }
    }
}


