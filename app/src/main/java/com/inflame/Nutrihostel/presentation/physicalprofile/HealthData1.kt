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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowDown
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.inflame.Nutrihostel.presentation.theme.NutriBackground
import com.inflame.Nutrihostel.presentation.theme.NutriDivider
import com.inflame.Nutrihostel.presentation.theme.NutriGreen
import com.inflame.Nutrihostel.presentation.theme.NutriGreenDark
import com.inflame.Nutrihostel.presentation.theme.NutriHostelTheme
import com.inflame.Nutrihostel.presentation.theme.NutriTextPrimary
import com.inflame.Nutrihostel.presentation.theme.NutriTextSecondary
import com.inflame.Nutrihostel.presentation.theme.NutriWhite
import com.inflame.Nutrihostel.presentation.theme.RoleStudentBg


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HealthData1Preview() {
    NutriHostelTheme {
        HealthData1()
    }
}

@Composable
fun HealthData1() {
    var selectedGender by remember { mutableStateOf("Female") }
    var age by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var activityLevel by remember { mutableStateOf("") }

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
            // Header: Step and Title
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Step 1 of 2",
                    style = MaterialTheme.typography.bodySmall,
                    color = NutriTextSecondary
                )
                Text(
                    text = "Physical Profile",
                    style = MaterialTheme.typography.bodySmall,
                    color = NutriTextSecondary
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Progress Bar
            LinearProgressIndicator(
                progress = { 0.50f },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp),
                color = NutriGreenDark,
                trackColor = NutriDivider,
                strokeCap = androidx.compose.ui.graphics.StrokeCap.Round
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Title and Description
            Text(
                text = "Your Physical Profile",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = NutriTextPrimary
            )
            Text(
                text = "This helps us calculate your daily nutritional needs and tailor meal plans for you.",
                style = MaterialTheme.typography.bodyMedium,
                color = NutriTextSecondary,
                modifier = Modifier.padding(top = 8.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Gender",
                style = MaterialTheme.typography.titleMedium,
                color = NutriTextPrimary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(NutriBackground, RoundedCornerShape(24.dp))
                    .padding(4.dp)
            ) {
                listOf("Female", "Male", "Other").forEach { gender ->
                    val isSelected = selectedGender == gender
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .background(
                                if (isSelected) NutriGreen else Color.Transparent,
                                RoundedCornerShape(20.dp)
                            )
                            .clickable { selectedGender = gender }
                            .padding(vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = gender,
                            style = MaterialTheme.typography.bodyMedium,
                            color = if (isSelected) NutriWhite else NutriTextSecondary,
                            fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Age and Height
            Row(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Age",
                        style = MaterialTheme.typography.bodyMedium,
                        color = NutriTextSecondary
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    CustomTextField(
                        value = age,
                        onValueChange = { age = it },
                        placeholder = "21"
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Height (cm)",
                        style = MaterialTheme.typography.bodyMedium,
                        color = NutriTextSecondary
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    CustomTextField(
                        value = height,
                        onValueChange = { height = it },
                        placeholder = "170"
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Weight
            Text(
                text = "Weight (kg)",
                style = MaterialTheme.typography.bodyMedium,
                color = NutriTextSecondary
            )
            Spacer(modifier = Modifier.height(4.dp))
            CustomTextField(
                value = weight,
                onValueChange = { weight = it },
                placeholder = "65",
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Activity Level
            Text(
                text = "Activity Level",
                style = MaterialTheme.typography.bodyMedium,
                color = NutriTextSecondary
            )
            Spacer(modifier = Modifier.height(4.dp))
            OutlinedTextField(
                value = activityLevel,
                onValueChange = { activityLevel = it },
                placeholder = { Text("Select activity level") },
                trailingIcon = { Icon(Icons.Default.KeyboardArrowDown, contentDescription = null) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                readOnly = true,
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = RoleStudentBg.copy(alpha = 0.5f),
                    focusedContainerColor = RoleStudentBg.copy(alpha = 0.5f),
                    unfocusedBorderColor = NutriGreen.copy(alpha = 0.3f),
                    focusedBorderColor = NutriGreen
                )
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(
                    onClick = {  },
                    modifier = Modifier
                        .weight(0.4f)
                        .height(56.dp),
                    shape = RoundedCornerShape(28.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = RoleStudentBg,
                        contentColor = NutriGreenDark
                    )
                ) {
                    Text("Back", style = MaterialTheme.typography.titleMedium)
                }

                Button(
                    onClick = {  },
                    modifier = Modifier
                        .weight(0.6f)
                        .height(56.dp),
                    shape = RoundedCornerShape(28.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = NutriGreenDark
                    )
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("Next", style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null)
                    }
                }
            }
        }
    }
}

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(placeholder, color = NutriTextSecondary.copy(alpha = 0.5f)) },
        modifier = modifier,
        shape = RoundedCornerShape(24.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = RoleStudentBg.copy(alpha = 0.5f),
            focusedContainerColor = RoleStudentBg.copy(alpha = 0.5f),
            unfocusedBorderColor = NutriGreen.copy(alpha = 0.3f),
            focusedBorderColor = NutriGreen
        )
    )
}


