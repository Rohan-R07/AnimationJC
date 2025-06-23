package com.practice.animationjc.Navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.practice.animationjc.MainScreen
import com.practice.animationjc.SplashScreen

@Composable
fun SplashScreenNavigation(contentPadding: PaddingValues) {

    val backStack = rememberNavBackStack<Screens>(Screens.SplashScreen)
    NavDisplay(
        backStack = backStack,
        modifier = Modifier
            .padding(contentPadding),
        entryProvider = entryProvider {
            entry<Screens.SplashScreen> { key ->
                SplashScreen(backStack)
            }

            entry<Screens.HomeScreen> { key ->
                MainScreen()
            }
        },
    )
}