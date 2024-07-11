package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            withTheme()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun withTheme() {
    ArtSpaceTheme {
        Scaffold(
            topBar = {
                Column {
                    TopAppBar(
                        title = {
                            Text(
                                text = stringResource(R.string.theTitle),
                                style = MaterialTheme.typography.titleLarge,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentSize(Alignment.Center)
                            )
                        },
                        colors = TopAppBarDefaults.smallTopAppBarColors(
                            containerColor = Color.Yellow,
                            titleContentColor = Color.Red,
                        ),
                        modifier = Modifier
                    )  // TopAppBar
                    Canvas(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(4.dp)
                    ) {
                        drawLine(
                            color = Color.Red,
                            start = Offset(0f, 0f),
                            end = Offset(size.width, 0f),
                            strokeWidth = 8.dp.toPx()
                        )
                    }
                }
            },
            modifier = Modifier.fillMaxSize(),
        ) { innerPadding ->
            ArtSpaceApp(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxSize(),
        color = Color.White
    ) {

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    withTheme()
}