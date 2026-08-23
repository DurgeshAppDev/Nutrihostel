package com.inflame.Nutrihostel.presentation.Auth

import android.graphics.Paint
import androidx.compose.foundation.background
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
import androidx.compose.foundation.style.styleable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.PermIdentity
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.keepScreenOn
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.room.util.TableInfo
import com.inflame.Nutrihostel.presentation.navigation.Routes
import com.inflame.Nutrihostel.presentation.theme.NutriBackground
import com.inflame.Nutrihostel.presentation.theme.NutriDivider
import com.inflame.Nutrihostel.presentation.theme.NutriGreen
import com.inflame.Nutrihostel.presentation.theme.NutriTextPrimary
import com.inflame.Nutrihostel.presentation.theme.NutriTextSecondary
import com.inflame.Nutrihostel.presentation.theme.RoleStudentBg


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterScreen() {
    var fullName by remember { mutableStateOf("")}
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false)}
    var confirmPassword by remember { mutableStateOf("") }
    var confirmPasswordVisible by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(RoleStudentBg, NutriBackground)
                )
            )
    ){
        IconButton(
            onClick = {},
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) { Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back"
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Create New Account",
                style = MaterialTheme.typography.headlineMedium,
                color = NutriTextPrimary
            )
            Spacer(modifier = Modifier.height(30.dp))

            OutlinedTextField(
                value = fullName ,
                onValueChange = {fullName = it},
                label = { Text("Full Name")},
                placeholder = {Text("Enter Your Full Name")},
                leadingIcon = {
                    Icon(Icons.Default.PermIdentity, contentDescription = null, tint= NutriTextSecondary)
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = NutriGreen,
                    unfocusedTextColor = NutriDivider
                )
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = email ,
                onValueChange = {email = it},
                label = { Text("Email")},
                placeholder = {Text("Enter Your Email")},
                leadingIcon = {
                    Icon(Icons.Default.Email, contentDescription = null, tint= NutriTextSecondary)
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = NutriGreen,
                    unfocusedTextColor = NutriDivider
                )
            )
            Spacer(modifier = Modifier.height(16.dp))


            OutlinedTextField(
                value = password ,
                onValueChange = {password = it},
                label = { Text("Password")},
                placeholder = {Text("Enter Your password")},
                leadingIcon = {
                    Icon(Icons.Default.Lock, contentDescription = null, tint= NutriTextSecondary)
                },
                trailingIcon = {
                    val icon = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                    IconButton(onClick = {passwordVisible = !passwordVisible}) {
                        Icon(icon, contentDescription = null,tint = NutriTextSecondary)
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = NutriGreen,
                    unfocusedTextColor = NutriDivider
                )
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = confirmPassword ,
                onValueChange = {confirmPassword = it},
                label = { Text("Confirm Password")},
                placeholder = {Text("Confirm  Your password")},
                leadingIcon = {
                    Icon(Icons.Default.Lock, contentDescription = null, tint= NutriTextSecondary)
                },
                trailingIcon = {
                    val icon = if (confirmPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                    IconButton(onClick = {confirmPasswordVisible = !confirmPasswordVisible}) {
                        Icon(icon, contentDescription = null,tint = NutriTextSecondary)
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = NutriGreen,
                    unfocusedTextColor = NutriDivider
                )
            )

            Spacer(modifier=Modifier.height(32.dp))

            Button(
                onClick = { },
                modifier= Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.buttonColors(containerColor = NutriGreen)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text("Sign Up", color = Color.White, style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null, tint = Color.White)
                }
            }






        }
    }
}