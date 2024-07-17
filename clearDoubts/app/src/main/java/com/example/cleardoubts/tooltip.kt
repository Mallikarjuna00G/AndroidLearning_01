package com.example.cleardoubts

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp

@Composable
fun Tooltip(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxSize()
    ){
        var showToolTip by remember { mutableStateOf(false) }
        var tooltipTapPosition by remember { mutableStateOf(Offset.Zero) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTapGestures(
                        onLongPress = { offset ->
                            showToolTip = true
                            tooltipTapPosition = offset
                        },
                        onTap = {
                            showToolTip = false
                        }
                    )
                },
            contentAlignment = Alignment.Center
        ) {
            Column(modifier = Modifier) {
                Text(
                    text = "Tooltip",
                    modifier = Modifier
                )
                if (showToolTip) {
                    var text by remember {
                        mutableStateOf("I am a tooltip")
                    }
                    Box(
                        modifier = Modifier
                            .border(width = 1.dp, color = Color.Red)
                            .background(color = Color.Yellow.copy(alpha = 0.7f))
                            .pointerInput(Unit) {
                                detectTapGestures(
                                    onTap = {
                                        text = "Hello again"
                                    }
                                )
                            }
                    ) {
                        Text(
                            text = text
                        )
                    }
                }
            }
        }
    } // Surface
}