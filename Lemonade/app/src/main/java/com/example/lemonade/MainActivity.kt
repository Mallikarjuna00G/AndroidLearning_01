package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                Scaffold(
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = {
                                Text(
                                    text = stringResource(id = R.string.app_name),
                                    fontWeight = FontWeight.Bold
                                )
                            },
                            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                                containerColor = Color.Yellow.copy(alpha = 0.5f)
                            )
                        )
                    }
                ) { innerPadding ->
                    LemonadeApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LemonadeApp(
    modifier: Modifier = Modifier
) {
    var step by remember{mutableStateOf(value = 1)}
    var squeezeFlag by remember{mutableStateOf(value = 0)}
    var squeezeCount by remember{mutableStateOf(value = 0)}

    val squeezer = {
        if(squeezeFlag == 0){
            step = (step % 4) + 1
            if(step == 2){
                squeezeFlag = 1
                squeezeCount = (2..4).random()
            }
        }
        else{
            squeezeCount--
        }
        if(squeezeCount == 0){
            squeezeFlag = 0
        }
    }

    val currentStep = CurrentStepLemonade()
    lemonadeStepResourceUpdate(currentStep, step)

    Surface(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Gray.copy(alpha = 0.3f)),
        color = Color.Gray.copy(alpha = 0.2f)
    ) {
        Column(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = currentStep.getCurrentStepImage()),
                contentDescription = currentStep.getCurrentStepImageDescription(),
                modifier = Modifier
                    .wrapContentSize()
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.Green.copy(alpha = 0.3f))
                    .padding(12.dp)
                    .clickable { squeezer() },
            )    // end of Image
            Spacer(
                modifier = Modifier
                    .height(12.dp)
            )
            Text(
                text = currentStep.getCurrentStepText(),
                modifier = Modifier.padding(20.dp),
                fontSize = 18.sp
            )
        }
    }
}

@Composable
fun lemonadeStepResourceUpdate(currentStep: CurrentStepLemonade, step: Int = 1) {
    when(step){
        1 -> currentStep.stepContentUpdate(
            image = R.drawable.lemon_tree,
            imageDescription = stringResource(id = R.string.description_lemonTree),
            text = stringResource(id = R.string.lemonTree)
        )
        2 -> currentStep.stepContentUpdate(
            image = R.drawable.lemon_squeeze,
            imageDescription = stringResource(id = R.string.description_lemon),
            text = stringResource(id = R.string.lemon)
        )
        3 -> currentStep.stepContentUpdate(
            image = R.drawable.lemon_drink,
            imageDescription = stringResource(id = R.string.description_glassOfLemonade),
            text = stringResource(id = R.string.glassOfLemonade)
        )
        else -> currentStep.stepContentUpdate(
            image = R.drawable.lemon_restart,
            imageDescription = stringResource(id = R.string.description_emptyGlass),
            text = stringResource(id = R.string.emptyGlass)
        )
    }
}

class CurrentStepLemonade() {
    protected var image: Int = 0
    protected var imageDescription: String = ""
    protected var text: String = ""

    fun stepContentUpdate(image: Int, imageDescription: String, text: String) {
        this.image = image
        this.imageDescription = imageDescription
        this.text = text
    }
    fun getCurrentStepImage(): Int {
        return image
    }
    fun getCurrentStepImageDescription(): String {
        return imageDescription
    }
    fun getCurrentStepText(): String {
        return text
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeAppPreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}