package com.sabrina.jetpackpractise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.sabrina.jetpackpractise.bottomnavigation.BottomNavItem
import com.sabrina.jetpackpractise.bottomnavigation.BottomNavigationBar
import com.sabrina.jetpackpractise.bottomnavigation.Navigation
import com.sabrina.jetpackpractise.instagram.IgProfileScreen
import com.sabrina.jetpackpractise.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

                val navController = rememberNavController()

                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavItem("Home", "home", Icons.Default.Home),
                                BottomNavItem("Chat", "chat", Icons.Default.Notifications),
                                BottomNavItem("Settings", "settings", Icons.Default.Settings)
                            ),
                            navController = navController,
                            onItemClick = { item ->
                                navController.navigate(item.route)
                            }
                        )
                    }
                ) { padding ->
                    Navigation(
                        navController = navController,
                        modifier = Modifier.padding(padding)
                    )
                }
        }
    }
}



