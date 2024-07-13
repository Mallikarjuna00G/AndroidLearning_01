package com.example.artspace2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradientShader
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace2.ui.theme.ArtSpace2Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme (
                colorScheme = darkColorScheme(
                    primary = Color.Black,
                    onPrimary = Color.White,
                    secondary = Color.Yellow,
                    onSecondary = Color.Red,
                    background = Color.Black,
                    onBackground = Color.White,
                    surface = Color.Black,
                    onSurface = Color.White
                )
            ) {
                WithTheme()
            }
        }
    }
}

@Composable
fun WithTheme() {
    ArtSpace2Theme {
        Scaffold(
            topBar = {TopAppBarDecoration(modifier = Modifier)},
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) { innerPadding ->
            ArtSpace2App(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarDecoration(
    modifier: Modifier = Modifier
) {
    Column{
        TopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.theTitle),
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.ExtraBold
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
                .fillMaxWidth(),
            contentDescription = null.toString(),
        ) {
            drawLine(
                color = Color.Red,
                start = Offset(0f, 0f),
                end = Offset(size.width, 0f),
                strokeWidth = 12f
            )  // Line
        }  // Canvas
    }  // Column
}  // TopBar

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WithTheme()
}

@Composable
fun ArtSpace2App(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(
            modifier = Modifier
                .padding(2.dp)
                .fillMaxWidth()
                .background(Color.Black),
            verticalArrangement = Arrangement.spacedBy(2.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Section1(
                modifier = Modifier
//                    .border(width = 2.dp, color = Color.Red)
                    .weight(40f)
                    .fillMaxWidth()
                    .wrapContentSize()
                    .background(Color.Black)
            )
            Section2(
                modifier = Modifier
//                    .border(width = 2.dp, color = Color.Green)
                    .weight(33f)
                    .fillMaxWidth()
                    .wrapContentSize()
                    .background(Color.Black)
            )
            Section3(
                modifier = Modifier
//                    .border(width = 2.dp, color = Color.Blue)
                    .weight(7f)
                    .fillMaxWidth()
                    .wrapContentSize()
                    .background(Color.Black)
            )
            Section4(
                modifier = Modifier
//                    .border(width = 2.dp, color = Color.Blue)
                    .weight(7f)
                    .fillMaxWidth()
                    .wrapContentSize()
                    .background(Color.Black)
            )
        }
    }  // Surface
}  // ArtSpace2App

@Composable
fun Section1(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .padding(28.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.rajkumar),
            contentDescription = null.toString(),
            modifier = modifier
                .fillMaxHeight()
                .background(Color.Black)
                .border(
                    width = 8.dp,
                    shape = RectangleShape,
                    brush = Brush.verticalGradient(
                        listOf(
                            Color.Yellow,
                            Color.Red,
                        )
                    )
                ),
            contentScale = ContentScale.FillHeight
        )
    }
}

@Composable
fun Section2(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier
                .padding(2.dp)
                .fillMaxWidth()
                .background(color = Color.Black),
            verticalArrangement = Arrangement.spacedBy(2.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "ರಾಜ್ ಕುಮಾರ್"
            )
            SpecialLine(modifier = Modifier)
            Column(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Row(
                    modifier = Modifier
                ) {
                    Text(text = "ಇತರೆ ಹೆಸರು: ", modifier = Modifier.weight(3f))
                    Text(text = "ಸಿಂಗಾನಲ್ಲೂರು ಪುಟ್ಟಸ್ವಾಮಯ್ಯ ಮುತ್ತುರಾಜು, ಅಣ್ಣಾವ್ರು", modifier = Modifier.weight(7f))
                }
                SimpleLine(modifier = Modifier)
                Row(
                    modifier = Modifier
                ) {
                    Text(text = "ಜನನ: ", modifier = Modifier.weight(3f))
                    Text(text = "ಸ೨೪ ಏಪ್ರಿಲ್, ೧೯೨೯\nಗಾಜನೂರು, ಮೈಸೂರು ಸಂಸ್ಥಾನ, ಬ್ರಿಟಿಷ್ ಭಾರತ", modifier = Modifier.weight(7f))
                }
                SimpleLine(modifier = Modifier)
                Row(
                    modifier = Modifier
                ) {
                    Text(text = "ಮರಣ: ", modifier = Modifier.weight(3f))
                    Text(text = "12 ಏಪ್ರಿಲ್ 2006 (ವಯಸ್ಸು - 76)\nಬೆಂಗಳೂರು, ಕರ್ನಾಟಕ, ಭಾರತ", modifier = Modifier.weight(7f))
                }
                SimpleLine(modifier = Modifier)
                Row(
                    modifier = Modifier
                ) {
                    Text(text = "ಕೊಡುಗೆ ರೂಪಗಳು: ", modifier = Modifier.weight(3f))
                    Text(text = "ನಾಯಕ ನಟ, ಗಾಯಕ, ನಿರ್ಮಾಪಕ, ಸಹ ನಟ", modifier = Modifier.weight(7f))
                }
                SimpleLine(modifier = Modifier)
                Row(
                    modifier = Modifier
                ) {
                    Text(text = "ಮೊದಲ ಚಿತ್ರ: ", modifier = Modifier.weight(3f))
                    Text(text = "ಬೇಡರ ಕಣ್ಣಪ್ಪ", modifier = Modifier.weight(7f))
                }
                SimpleLine(modifier = Modifier)
                Row(
                    modifier = Modifier
                ) {
                    Text(text = "ಬಿರುದುಗಳು: ", modifier = Modifier.weight(3f))
                    Text(text = "ನಟಸಾರ್ವಭೌಮ, ಕರ್ನಾಟಕ ರತ್ನ, ವರನಟ,ಅಣ್ಣಾವ್ರು", modifier = Modifier.weight(7f))
                }
            }  // Column
            SpecialLine(modifier = Modifier)
        }
    }
}

@Composable
fun SimpleLine(modifier: Modifier) {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp),
        contentDescription = null.toString(),
    )
    {
        drawLine(
            color = Color.Yellow,
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
        )
    }
}

@Composable
fun SpecialLine(
    modifier: Modifier = Modifier
) {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 2.dp),
        contentDescription = null.toString(),
    ) {
        drawLine(
            color = Color.Yellow,
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
            strokeWidth = 8f
        )
        drawLine(
            color = Color.Red,
            start = Offset(0f, 8f),
            end = Offset(size.width, 8f),
            strokeWidth = 8f
        )
    }
}

@Composable
fun Section3(
    modifier: Modifier
) {
    Surface(
        modifier = modifier
            .border(width = 2.dp, color = Color.Red)
            .padding(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "ಸಂಗ್ರಹ: ")
            Text(text = "ನಾಯಕ ನಟ")
        }
    }
}

@Composable
fun Section4(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {},
                modifier = Modifier
                    .padding(2.dp)
                    .weight(3f)
                    .background(brush = Brush.verticalGradient(listOf(Color.Yellow, Color.Red))),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Yellow,
                    contentColor = Color.Red
                )
            ) {
                Text(text = "ಹಿಂದಿನ")
            }
            Spacer(modifier = Modifier.weight(4f))
            Button(
                onClick = {},
                modifier = Modifier
                    .padding(2.dp)
                    .weight(3f)
                    .background(brush = Brush.verticalGradient(listOf(Color.Yellow, Color.Red))),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Yellow,
                    contentColor = Color.Red
                )
            ) {
                Text(text = "ಮುಂದಿನ")
            }
        }
    }
}
