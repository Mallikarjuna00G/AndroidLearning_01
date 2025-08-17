package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
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
    ) {
        QuadrantRow(
            title1 = stringResource(R.string.title1),
            description1 = stringResource(R.string.description1),
            title2 = stringResource(R.string.title2),
            description2 = stringResource(R.string.description2),
            bgColor1 = Color(color = 0xFFEADDFF),
            bgColor2 = Color(color = 0xFFD0BCFF),
            modifier = Modifier.weight(1f)
        )
        QuadrantRow(
            title1 = stringResource(R.string.title3),
            description1 = stringResource(R.string.description3),
            title2 = stringResource(R.string.title4),
            description2 = stringResource(R.string.description4),
            bgColor1 = Color(color = 0xFFB69DF8),
            bgColor2 = Color(color = 0xFFF6EDFF),
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun QuadrantRow(
    title1: String,
    description1: String,
    title2: String,
    description2: String,
    bgColor1: Color,
    bgColor2: Color,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        Quadrant(
            quadrantTitle = title1,
            quadrantDescription = description1,
            modifier = Modifier
                .weight(weight = 1f, fill = true)
                .background(color = bgColor1)
        )
        Quadrant(
            quadrantTitle = title2,
            quadrantDescription = description2,
            modifier = Modifier
                .weight(weight = 1f, fill = true)
                .background(color = bgColor2)
        )
    }
}

@Composable
fun Quadrant(
    quadrantTitle: String,
    quadrantDescription: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(all = 8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = quadrantTitle,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Justify,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = quadrantDescription,
            textAlign = TextAlign.Justify,
            color = Color.Black
        )

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            ComposeQuadrantApp(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}