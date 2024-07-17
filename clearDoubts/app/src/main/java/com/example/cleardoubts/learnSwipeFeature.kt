package com.example.cleardoubts

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun LearnSwiper(
    modifier: Modifier
) {
    Surface(modifier = modifier) {
        var number by remember { mutableIntStateOf(0) }
        var number2 by remember { mutableIntStateOf(0) }

        var offsetX by remember { mutableFloatStateOf(0f) }
        val maxOffsetX = with(LocalDensity.current) {100.dp.toPx()}  // maximum drag distance
        var dragDirection by remember { mutableIntStateOf(0) }
        var isDragging by remember { mutableStateOf(false) }

        Column(
            modifier = modifier.fillMaxSize()
        ) {
            Text(
                text = "number: $number",
                modifier = Modifier
                    .offset { IntOffset(offsetX.roundToInt(), 0) }
                    .pointerInput(Unit) {
                        detectHorizontalDragGestures { change, dragAmount ->
                            change.consume()
                            offsetX += dragAmount
                            offsetX = offsetX.coerceIn(0f, maxOffsetX)
                            if (dragAmount > 0) {
                                number++
                            } else {
                                number--
                            }
                        }
                    }
                    .padding(16.dp)
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .border(width = 2.dp, color = Color.Red)
                    .background( color =
                        if (isDragging) {
                            if(dragDirection > 0)
                                Color.Yellow.copy(alpha = 0.7f)
                            else
                                Color.Red.copy(alpha = 0.7f)
                        }else {
                            Color.Black
                        }
                    )
                    .pointerInput(Unit) {
                        detectHorizontalDragGestures(
                            onDragStart = {},
                            onDragEnd = {
                                if (dragDirection > 0) {
                                    number2++
                                } else {
                                    number2--
                                }
                                isDragging = false
                            },
                            onDragCancel = {},
                            onHorizontalDrag = { change, dragAmount ->
                                change.consume()
                                dragDirection = dragAmount.toInt()
                                isDragging = true
                            }
                        )
                    }
            ) {
                Text(
                    text = "number: $number2",
                    modifier = Modifier
                    .border(width = 2.dp, color = Color.Red)
                )
            }
        }
    }
}