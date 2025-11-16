package com.sabrina.jetpackpractise.permissionhandling

import android.Manifest
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.accompanist.permissions.shouldShowRationale

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionHandling() {
    val permissionsState = rememberMultiplePermissionsState(
        permissions = listOf(
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.CAMERA
        )
    )

    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(key1 = lifecycleOwner, effect = {
        val observer = LifecycleEventObserver{_,event ->
            if (event == Lifecycle.Event.ON_RESUME){
                permissionsState.launchMultiplePermissionRequest()
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer = observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    })

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        permissionsState.permissions.forEach { perm->
            when(perm.permission){
                Manifest.permission.CAMERA -> {
                    when{
                         perm.status.isGranted ->{
                             Text(text = "Camera permission accepted")
                         }
                        perm.status.shouldShowRationale ->{
                            Text(text = "Camera permission is need to access the camera")
                        }
                         perm.isPermanentlyDenied()->{
                             Text(text = "Camera permission denied permanently. You can enable it in the app settings")
                        }
                    }
                }
                Manifest.permission.RECORD_AUDIO ->{
                    when{
                        perm.status.isGranted ->{
                            Text(text = "Record audio permission accepted")
                        }
                        perm.status.shouldShowRationale ->{
                            Text(text = "Record audio permission is need to access the audio")
                        }
                        perm.isPermanentlyDenied()->{
                            Text(text = "Record audio  permission denied permanently. You can enable it in the app settings")
                        }
                    }
                }
            }
        }
    }
}