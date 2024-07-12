package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            Leveraging data from "kannadaKings.kt" to avoid repetition of code
            val kings: MutableList<King> = mutableListOf()
            updateKingsList(kings = kings)
            withTheme(kings = kings)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun withTheme(kings: MutableList<King>) {
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
                kings = kings,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Composable
fun ArtSpaceApp(
    kings: MutableList<King>,
    modifier: Modifier = Modifier
) {
    var currentKing by remember { mutableStateOf(0) }
    val king = kings[currentKing]
    val kingsCount by remember { mutableStateOf(kings.size) }
//    val kingsCount by remember { mutableStateOf(3) }  // Hardcoded for now

    Surface(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Magenta),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
            ,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .weight(1f),
                verticalArrangement = Arrangement.Center,
            ){
                Image(
                    painter = painterResource(R.drawable.kingsilhoutte),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(0.dp))
                        .padding(8.dp)
                        .shadow(
                            elevation = 18.dp,
                            ambientColor = Color.Green,
                            spotColor = Color.Blue,
                            shape = RectangleShape,
                            clip = false,
                        )
                        .background(color = Color.LightGray.copy(alpha = 0.1f)),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 16.dp, start = 8.dp, end = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                /* king name */
                Text(
                    text = king.getName(),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 32.sp,
                    ),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                /* Special underline */
                speacialUnderline(modifier = Modifier.align(Alignment.CenterHorizontally))
                /* king's other names */
                Text(
                    text = king.getOtherNames(),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                /* king's empire */
                Text(
                    text = "ಸಾಮ್ರಾಜ್ಯ: " + king.getEmpire(),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 24.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                /* king's kaala */
                Text(
                    text = "ಕಾಲ: " + king.getKaala(),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                /* king's avadhi */
                Text(
                    text = "ಆಳ್ವಿಕೆ ಅವಧಿ (ವರ್ಷ): " + king.getAvadhi(),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                btnsNextPrevious(
                    isNext = false,
                    onClickOp = {currentKing = if (currentKing == 0) kingsCount - 1 else --currentKing},
                    text = stringResource(R.string.btnPreviousText),
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )
                btnsNextPrevious(
                    isNext = true,
                    onClickOp = {currentKing = if (currentKing == kingsCount - 1) 0 else ++currentKing},
                    text = stringResource(R.string.btnNextText),
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
        }
    }
}

@Composable
fun btnsNextPrevious(
    isNext: Boolean = true,
    onClickOp: () -> Unit,
    text: String = "",
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClickOp,
        modifier = modifier
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun speacialUnderline(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(4.dp)
    ) {
        drawLine(
            color = Color.Yellow,
            start = Offset(12f, 0f),
            end = Offset(size.width - 12f, 0f),
            strokeWidth = 2.dp.toPx()
        )
        drawLine(
            color = Color.Red,
            start = Offset(12f, size.height - 3f),
            end = Offset(size.width - 12f, size.height - 3f),
            strokeWidth = 2.dp.toPx()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    withTheme(kings = mutableListOf())
}