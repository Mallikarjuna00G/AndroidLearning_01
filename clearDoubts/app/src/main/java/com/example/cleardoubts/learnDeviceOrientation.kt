package com.example.cleardoubts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun LearnDeviceOrientation(
    modifier: Modifier
) {
    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        val deviceOrientation = LocalConfiguration.current.orientation
        Text(
            text = deviceOrientation.toString(),
            modifier = Modifier
        )
        if(deviceOrientation == 1) {
            Column {
                Text(
                    text = "Portrait",
                    modifier = Modifier
                )
                Text(
                    text = "Portrait",
                    modifier = Modifier
                )
            }
        } else {
            Row {
                Text(
                    text = "Landscape",
                    modifier = Modifier
                )
                Text(
                    text = "Landscape",
                    modifier = Modifier
                )
            }
        }
    }
}
