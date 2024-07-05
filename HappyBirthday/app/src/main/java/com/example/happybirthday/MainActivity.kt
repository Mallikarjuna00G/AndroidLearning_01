package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                        .border(width = 1.dp, color = Color.Blue),
                    contentColor = MaterialTheme.colorScheme.background,
                    containerColor = Color.LightGray
                ) { innerPadding ->
                    // A surface container using the 'background' color from the theme
                    GreetingText(
                        modifier = Modifier.padding(innerPadding),
                        message = "Happy Birthday Raghva!!",
                        from = "From Mallikarjuna"
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(
    modifier: Modifier = Modifier,
    message: String,
    from: String
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .border(width = 2.dp, color = Color.Red)
            .fillMaxSize()
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        GreetingText(message = "Happy Birthday Raghva!!", from = "From Mallikarjuna")
    }
}