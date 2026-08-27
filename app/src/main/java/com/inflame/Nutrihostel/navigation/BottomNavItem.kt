package com.inflame.Nutrihostel.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiPeople
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector


@Composable
fun BottomNavbar(){

    val navItems = listOf(
        NavItem(
            title = "Home",
            icon = Icons.Default.Home,
            route = Routes.HomeScreen
        ),
        NavItem(
            title = "Profile",
            icon = Icons.Default.Person,
            route = Routes.ProfileScreen
        ),
        NavItem(
            title = "Meals",
            icon = Icons.Default.EmojiPeople,
            route = Routes.MealsScreen
        )
    )

    NavigationBar {
        navItems.forEach { item ->
            NavigationBarItem(
                selected = false,
                onClick = {},
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = { Text(text = item.title) }
            )
        }
    }
}


data class NavItem(
    val title: String,
    val icon: ImageVector,
    val route: Routes
)
