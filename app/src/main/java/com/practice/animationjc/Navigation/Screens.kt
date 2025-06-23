package com.practice.animationjc.Navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed  class Screens () : NavKey{

    @Serializable
    data object SplashScreen : Screens()

    @Serializable
    data object HomeScreen : Screens()
}