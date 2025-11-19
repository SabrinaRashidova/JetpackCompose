package com.sabrina.jetpackpractise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sabrina.jetpackpractise.animation.ProfileHeader
import com.sabrina.jetpackpractise.animation.ProfileHeaderSetUp
import com.sabrina.jetpackpractise.pagination.SetUpPaginator
import com.sabrina.jetpackpractise.permissionhandling.PermissionHandling
import com.sabrina.jetpackpractise.scrolleffect.ScrollEffect

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetUpPaginator()
        }
    }
}



