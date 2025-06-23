package com.practice.animationjc

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.EaseInOutCubic
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun MainScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

        var animatedContentState by remember { mutableStateOf(true) }
        var transitionState = updateTransition(
            targetState = animatedContentState,
            label = "transition"
        )

//                    val icon = transitionState.animateInt(
//                        label = "Toggle Icon",
//                        transitionSpec = { tween(durationMillis = 1000) },
//                        targetValueByState = { animatedContentState ->
//                            if (animatedContentState) R.drawable.outline_toggle_off_24
//                            else R.drawable.outline_toggle_on_24
//                        }
//                    )
        Row(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            IconButton(
                onClick = {
                    animatedContentState = !animatedContentState
                }
            ) {
                AnimatedVisibility(
                    visible = animatedContentState,
                ) {

                    Icon(
                        painter = painterResource(R.drawable.outline_toggle_off_24),
                        contentDescription = null
                    )
                }

                AnimatedVisibility(
                    visible = !animatedContentState
                ) {

                    Icon(
                        painter = painterResource(R.drawable.outline_toggle_on_24),
                        contentDescription = null
                    )
                }

            }
        }

        AnimatedContent(
            targetState = animatedContentState,
            modifier = Modifier
                .padding(top = 100.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.Center,
            content = { animatedContentState ->

                val transitionMmovingText = rememberInfiniteTransition()

                val movingText = transitionMmovingText.animateValue(
                    initialValue = 3.dp,
                    targetValue = 300.dp,
                    typeConverter = Dp.VectorConverter,
                    label = "movingText",
                    animationSpec = infiniteRepeatable(
                        animation = tween(
                            durationMillis = 1000,
                            delayMillis = 300,
                        ),
                        repeatMode = RepeatMode.Reverse
                    )

                )

                if (animatedContentState) {
                    LazyColumn {
                        item {
                            Column(
                                modifier = Modifier
                                    .padding()
                                    .fillMaxSize(),
                            ) {
                                // loop animation and animated Visibility
                                Column(
                                    modifier = Modifier
                                        .height(350.dp)
                                ) {
                                    var showBox by remember { mutableStateOf(false) }
                                    var alwaysRunning by remember { mutableStateOf(true) }


                                    Row(
                                        modifier = Modifier
                                            .wrapContentHeight()
                                            .fillMaxWidth(),
                                    ) {
                                        Button(
                                            onClick = {
                                                showBox = !showBox
                                            }
                                        ) {
                                            Text(text = "Animated Visibiltity")
                                        }

                                    }
                                    AnimatedVisibility(
                                        showBox,
                                        enter = expandHorizontally(
                                            animationSpec = spring(
                                                dampingRatio = Spring.DampingRatioHighBouncy,
                                                stiffness = Spring.StiffnessMedium,
                                            )
                                        ) + fadeIn(animationSpec = spring()),
                                        exit = shrinkVertically(
                                            animationSpec = spring(
                                                dampingRatio = Spring.DampingRatioMediumBouncy,
                                                stiffness = Spring.StiffnessMedium,
                                            )
                                        )
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .background(Red)
                                                .size(200.dp)
                                        ) {

                                        }

                                    }

                                    LaunchedEffect(Unit) {
                                        while (true) {
                                            delay(2000)
                                            alwaysRunning = !alwaysRunning
                                        }
                                    }

                                    AnimatedVisibility(alwaysRunning) {
                                        Box(
                                            modifier = Modifier
                                                .size(100.dp)
                                                .background(Green),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                "Always Running Animation",
                                                textAlign = TextAlign.Center,
                                                fontSize = 20.sp,
                                                color = Black
                                            )
                                        }
                                    }

                                }

                                // Size Animation
                                Column {// size animation

                                    var sizeAnimation by remember {
                                        mutableStateOf(
                                            false
                                        )
                                    }

                                    val roundedCornerAnimation by animateIntAsState(
                                        targetValue = if (sizeAnimation) 45 else 15,
                                        animationSpec = spring(
                                            dampingRatio = Spring.DampingRatioHighBouncy,
                                            stiffness = Spring.StiffnessLow
                                        )
                                    )
                                    Column(
                                        modifier = Modifier
                                            .height(350.dp)

                                    ) {
                                        Button(
                                            onClick = {
                                                sizeAnimation = !sizeAnimation
                                            }
                                        ) {
                                            Text("Change Shape")
                                        }
                                        Spacer(Modifier.padding(top = 10.dp))
                                        Box(
                                            modifier = Modifier
                                                .clip(
                                                    RoundedCornerShape(
                                                        roundedCornerAnimation
                                                    )
                                                )
                                                .background(Red)
                                                .size(200.dp),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                "Circle Animation",
                                                textAlign = TextAlign.Center,
                                                fontSize = 20.sp,
                                                color = Black
                                            )
                                        }
                                    }
                                }

                                // multiple value animation33
                                Column {
                                    var transitionState by remember {
                                        mutableStateOf(
                                            false
                                        )
                                    }
                                    val mutableTransition = updateTransition(
                                        targetState = transitionState,
                                        label = "transition"
                                    )

                                    val fatBorder by mutableTransition.animateDp(
                                        label = "fatBorder",
                                        transitionSpec = { tween(1000) },
                                        targetValueByState = { transitionState ->
                                            if (transitionState) 7.dp else 2.dp
                                        }
                                    )
                                    val boxColor by mutableTransition.animateColor(
                                        label = "boxColor",
                                        transitionSpec = {
                                            tween(
                                                durationMillis = 1000,
                                                easing = EaseInOutCubic
                                            )
                                        },
                                        targetValueByState = { transitionState ->
                                            if (transitionState) Red else Blue
                                        }
                                    )
                                    val boxSize by mutableTransition.animateDp(
                                        label = "boxSize",
                                        transitionSpec = {
                                            spring(
                                                dampingRatio = Spring.DampingRatioLowBouncy, // ik this is useless but it is work knowing here
                                                stiffness = Spring.StiffnessMedium
                                            )
                                        },
                                        targetValueByState = { transitionState ->
                                            if (transitionState) 200.dp else 100.dp
                                        }
                                    )

                                    Button(
                                        onClick = {
                                            transitionState = !transitionState
                                        }
                                    ) {
                                        Text("FatBorer|ColorFade")
                                    }

                                    Box(
                                        modifier = Modifier
                                            .size(boxSize)
                                            .background(boxColor)
                                            .border(BorderStroke(fatBorder, White))
                                    )
                                }

                                // infinity Transitiion State
                                Column(
                                    modifier = Modifier.height(350.dp)
                                ) {
                                    val infiniteTransition = rememberInfiniteTransition(
                                        label = "infiniteTransition",
                                    )
                                    val color by infiniteTransition.animateColor(
                                        initialValue = Green,
                                        targetValue = Blue,
                                        animationSpec = infiniteRepeatable(
                                            animation = tween(
                                                2000,
                                                delayMillis = 300,
                                            ),
                                            repeatMode = RepeatMode.Reverse
                                        )
                                    )
                                    val animateText by infiniteTransition.animateColor(
                                        initialValue = Black,
                                        targetValue = White,
                                        animationSpec = infiniteRepeatable(
                                            animation = tween(
                                                2000,
                                                delayMillis = 300,
                                            ),
                                            repeatMode = RepeatMode.Reverse

                                        )
                                    )

                                    Box(
                                        modifier = Modifier
                                            .size(130.dp)
                                            .background(color),
                                        contentAlignment = Alignment.Center,

                                        ) {
                                        Text(
                                            "Infinite Transition",
                                            fontSize = 30.sp,
                                            textAlign = TextAlign.Center,
                                            color = animateText
                                        )
                                    }
                                }
                            }
                        }
                    }
                } else {
                    Column(
                        modifier =Modifier,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text(
                            "Moving Text",
                            fontSize = 30.sp,
                            color = White,
                            fontWeight = FontWeight.Bold,
//                                        modifier = Modifier.padding(30.dp),
                            modifier = Modifier
                                .offset(x = movingText.value , y = movingText.value)
                                .background(Red)
//                                            .padding(start = movingText.value)

                        )
                    }
                }
            }
        )
    }
}