package com.practice.animationjc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.practice.animationjc.Navigation.SplashScreenNavigation
import com.practice.animationjc.ui.theme.AnimationJCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimationJCTheme {
                Scaffold(
                    modifier = Modifier

                ) { contentPdding ->

                    SplashScreenNavigation(contentPdding)
                }

            }
        }
    }
}


