package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LemonadeApp(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .background(color = Color(0xFF6DB06F))
                    )
                }
            }
        }
    }
}

@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            textAlign = TextAlign.Center,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth()
                .background(color = Color.Yellow),
        )
        Spacer(
            modifier = Modifier.height(height = 4.dp)
        )
        LemonadeMaker(modifier = modifier)
    }
}

@Composable
fun LemonadeMaker(modifier: Modifier = Modifier) {
    var step by remember { mutableStateOf(value = 1) }
    var stay_at by remember { mutableStateOf(value = 0) }

    var image = 0
    var img_txt = 0
    var text = 0

    when (step) {
        1 -> {
            image = R.drawable.lemon_tree
            img_txt = R.string.img_lemon_tree
            text = R.string.pick_lemon
        }
        2 -> {
            image = R.drawable.lemon_squeeze
            img_txt = R.string.img_lemon
            text = R.string.squeeze_lemon
        }
        3 -> {
            image = R.drawable.lemon_drink
            img_txt = R.string.img_lemonade
            text = R.string.drink_lemonade
        }
        else -> {
            image = R.drawable.lemon_restart
            img_txt = R.string.img_empty_glass
            text = R.string.start_again
        }
    }
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                if (stay_at > 0) {
                    --stay_at
                    if (stay_at == 1) {
                        step++
                    }
                } else {
                    when (step) {
                        2 -> stay_at = (2..4).random()
                        4 -> step = 1
                        else -> step++
                    }
                }
            },
            shape = RoundedCornerShape(size = 20.dp),
            colors = ButtonColors(
                containerColor = Color(0xFFFD9D9D),
                contentColor = Color.Black,
                disabledContainerColor = Color(0xFF6DB06F),
                disabledContentColor = Color.Black
            )
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = stringResource(id = img_txt)
            )
        }
        Spacer(
            modifier = Modifier.height(height = 32.dp)
        )
        Text(
            text = stringResource(id = text),
            fontSize = 18.sp
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Lemonade Preview"
)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            LemonadeApp(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(color = Color(0xFF6DB06F))
            )
        }
    }
}