package com.sabrina.jetpackpractise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sabrina.jetpackpractise.instagram.IgProfileScreen
import com.sabrina.jetpackpractise.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme{}
            IgProfileScreen()
        }
    }
}


