package com.example.cleardoubts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.cleardoubts.ui.theme.ClearDoubtsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            ClearDoubtsTheme {
                theTheme(modifier = Modifier.fillMaxSize())
            }

        }
    }
}

@Composable
fun theTheme(modifier: Modifier = Modifier) {
    MaterialTheme(
        colorScheme = darkColorScheme(
            primary = Color.Black,
            onPrimary = Color.White,
            background = Color.Black,
            onBackground = Color.White,
            surface = Color.Black,
            onSurface = Color.White,
        )
    ) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//            Greeting(
//                name = "Android",
//                modifier = Modifier.padding(innerPadding)
//            )
//            LearnDeviceOrientation(modifier = Modifier.padding(innerPadding))
//            LearnSwiper(modifier = Modifier.padding(innerPadding))
            Tooltip(modifier.padding(innerPadding))
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Hello $name!",
                modifier = modifier,
            )
            learningState(modifier = Modifier.fillMaxSize())
        }
    }
}

class LearningState(var var1: Int = 0, var var2: Int = 0) {}

@Composable
fun learningState(modifier: Modifier) {
    Surface(
        modifier = modifier
            .fillMaxSize()
    ) {
        var buttonClickedState by remember { mutableStateOf(0) }
        var learningState by remember { mutableStateOf(LearningState(var1 = 10, var2 = 10)) }
//        var learningState = LearningState(var1 = 10, var2 = 10)

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            buttonsSection1(
                buttonClickedStateInc = {
                    buttonClickedState++
                    learningState.var1++
                    learningState.var2++
                                        },
                buttonClickedStateDec = {
                    buttonClickedState--
                    learningState.var1--
                    learningState.var2--
                                        },
                modifier = modifier
                    .weight(1f)
            )
            section2(
                buttonClickedState = buttonClickedState,
                learningState = learningState,
                modifier = Modifier
                    .weight(1f)
            )
            // Section3 also getting recomposed when buttonClickedState changes
            section3(
                learningState = learningState,
                modifier = Modifier
                    .weight(1f)
            )
        }
    }
}

@Composable
fun section3(learningState: LearningState, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "Section3: ",
            modifier = Modifier
        )
        Text(
            text = learningState.var1.toString(),
            modifier = Modifier
        )
        Text(
            text = learningState.var2.toString(),
            modifier = Modifier
                .weight(1f)
        )
    }
}

@Composable
fun section2(buttonClickedState: Int, learningState: LearningState, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "Section2: ",
            modifier = Modifier
        )
//        Text(
//            text = buttonClickedState.toString(),
//            modifier = Modifier
//        )
        Text(
            text = learningState.var1.toString(),
            modifier = Modifier
        )
        Text(
            text = learningState.var2.toString(),
            modifier = Modifier
                .weight(1f)
        )
    }
}

@Composable
fun buttonsSection1(buttonClickedStateInc: () -> Unit, buttonClickedStateDec: () -> Unit, modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        buttonsSection2Concise(
            buttonClickedStateIncDec = buttonClickedStateInc,
            isNext = true,
            modifier = Modifier
                .weight(1f)
        )
        buttonsSection2Concise(
            buttonClickedStateIncDec = buttonClickedStateDec,
            isNext = false,
            modifier = Modifier
                .weight(1f)
        )
    }
}

@Composable
fun buttonsSection2Concise(
    buttonClickedStateIncDec: () -> Unit,
    isNext: Boolean,
    modifier: Modifier
) {
    var text = ""
    if(isNext) {
        text = "increment"
    }
    else {
        text = "decrement"
    }
    Button(
        onClick = buttonClickedStateIncDec,
        modifier = modifier
    ){
        Text(text = "Increment")
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    theTheme()
//}