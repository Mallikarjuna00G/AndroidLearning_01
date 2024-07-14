package com.example.artspace2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace2.ui.theme.ArtSpace2Theme
import com.example.artspace2.ui.theme.Typography

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            ArtSpace2Theme {
                WithTheme()
            }
        }
    }
}

@Composable
fun WithTheme() {
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
        ),
    ) {
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
                    .weight(35f)
                    .fillMaxWidth()
                    .wrapContentSize()
                    .background(Color.Black)
            )
            Section3(
                modifier = Modifier
//                    .border(width = 2.dp, color = Color.Blue)
                    .weight(5f)
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
                text = "ರಾಜ್ ಕುಮಾರ್",
                style = Typography.headlineMedium,
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
            ) {
                SpecialLine(
                    modifier = Modifier
                        .weight(1f))
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .weight(8f)
                ) {
                    val about = listOf(
                        listOf("ಇತರೆ ಹೆಸರು: ", "ಸಿಂಗಾನಲ್ಲೂರು ಪುಟ್ಟಸ್ವಾಮಯ್ಯ ಮುತ್ತುರಾಜು, ಅಣ್ಣಾವ್ರು"),
                        listOf("ಜನನ: ", "೨೪ ಏಪ್ರಿಲ್, ೧೯೨೯\nಗಾಜನೂರು, ಮೈಸೂರು ಸಂಸ್ಥಾನ, ಬ್ರಿಟಿಷ್ ಭಾರತ"),
                        listOf("ಮರಣ: ", "12 ಏಪ್ರಿಲ್ 2006 (ವಯಸ್ಸು - 76)\nಬೆಂಗಳೂರು, ಕರ್ನಾಟಕ, ಭಾರತ"),
                        listOf("ಕೊಡುಗೆ ರೂಪಗಳು: ", "ನಾಯಕ ನಟ, ಗಾಯಕ, ನಿರ್ಮಾಪಕ, ಸಹ ನಟ"),
                        listOf("ಮೊದಲ ಚಿತ್ರ: ", "ಬೇಡರ ಕಣ್ಣಪ್ಪ"),
                        listOf("ಬಿರುದುಗಳು: ", "ನಟಸಾರ್ವಭೌಮ, ಕರ್ನಾಟಕ ರತ್ನ, ವರನಟ,ಅಣ್ಣಾವ್ರು"),
                    )
                    LazyColumn() {
                        items(about.size) { index ->
                            Row(
                                modifier = Modifier
                            ) {
                                Text(text = about[index][0], modifier = Modifier.weight(3f))
                                Text(
                                    text = about[index][1],
                                    modifier = Modifier.weight(7f)
                                )
                            }
                            if (index != about.size - 1) {
                                SimpleLine(modifier = Modifier)
                            }
                        }
                    }  // LazyColumn
                }  // Column
                SpecialLine(
                    modifier = Modifier
                        .weight(1f)
                )
            }  // Column
        }  // Column
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
            .padding(horizontal = 2.dp)
//            .border(width = 1.dp, color = Color.White)
            .height(8.dp),
        contentDescription = null.toString(),
    ) {
        val strokeWidth = 8f
        val halfOfStrokeWidth = strokeWidth / 2
        var nextY = 0f
        drawLine(
            color = Color.Yellow,
            start = Offset(0f, halfOfStrokeWidth),
            end = Offset(size.width, halfOfStrokeWidth),
            strokeWidth = strokeWidth
        )
        nextY += strokeWidth
        drawLine(
            color = Color.Red,
            start = Offset(0f, nextY + halfOfStrokeWidth),
            end = Offset(size.width, nextY + halfOfStrokeWidth),
            strokeWidth = strokeWidth
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
            Text(text = "ಸಂಗ್ರಹ: ", style = Typography.headlineSmall)
            Text(text = "ನಾಯಕ ನಟ", style = Typography.headlineSmall)
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
            btnsNextOrPrevious(
                isNext = false,
                modifier = Modifier
                    .weight(3f)
            )
            Spacer(modifier = Modifier.weight(4f))
            btnsNextOrPrevious(
                isNext = true,
                modifier = Modifier
                    .weight(3f)
            )
        }
    }
}

@Composable
fun btnsNextOrPrevious(
    isNext: Boolean,
    modifier: Modifier = Modifier
) {
    val text = if(isNext) "ಮುಂದಿನ" else "ಹಿಂದಿನ"
    Button(
        onClick = {},
        modifier = Modifier
            .padding(2.dp)
            .background(brush = Brush.verticalGradient(listOf(Color.Yellow, Color.Red))),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Yellow,
            contentColor = Color.Red
        )
    ) {
        Text(text = text)
    }
}
