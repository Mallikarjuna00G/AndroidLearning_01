package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ComposeQuadrantApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrantApp(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Quadrant(
                title = stringResource(R.string.title1),
                description = stringResource(R.string.paragraph1),
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(16.dp))
            )
            Quadrant(
                title = stringResource(R.string.title2),
                description = stringResource(R.string.paragraph2),
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(16.dp))
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Quadrant(
                title = stringResource(R.string.title3),
                description = stringResource(R.string.paragraph3),
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(16.dp))
            )
            Quadrant(
                title = stringResource(R.string.title4),
                description = stringResource(R.string.paragraph4),
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(16.dp))
            )
        }
    }
}

@Composable
fun Quadrant(title: String, description: String, backgroundColor: Color, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(color = backgroundColor)
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
            textAlign = TextAlign.Justify,
            style = TextStyle(
                color = Color.Black,
            )
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify,
            style = TextStyle(
                color = Color.Black,
            )
        )
    }
}

@Preview(showBackground = false)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrantApp()
    }
}