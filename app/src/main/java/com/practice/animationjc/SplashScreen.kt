package com.practice.animationjc

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavBackStack
import com.practice.animationjc.Navigation.Screens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(backStack : NavBackStack) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var controlerState by remember { mutableStateOf(true) }

        LaunchedEffect(true) {
            controlerState = false
        }
        val infiniteTransition = rememberInfiniteTransition("LetterSpacing")
//
        val letterSpacing = infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 14f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 300,

                ),
                repeatMode = androidx.compose.animation.core.RepeatMode.Reverse
            )
        )

        LaunchedEffect(true) {
            delay(400)

            backStack.removeAll{true}
            backStack.add(Screens.HomeScreen)
        }

        Text(
            text = "Animation!",
            fontFamily = FontFamily(
                Font(
                    R.font.custom_font,
                )
            ),
            fontSize = 40.sp,
            letterSpacing = TextUnit(
                value = letterSpacing.value,
                type = TextUnitType.Sp
            )
        )
    }


}
