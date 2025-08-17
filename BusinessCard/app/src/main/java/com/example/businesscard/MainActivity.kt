package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCardApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(color = 0xFFD2E8D4)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            modifier = Modifier
                .weight(weight = 1f, fill = true),
        )
        Row(
            modifier = Modifier
                .weight(weight = 1f, fill = true),
        ) {
            Column(
                modifier = Modifier
                    .weight(weight = 1f, fill = true),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val image = painterResource(id = R.drawable.android_logo)
                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier
                        .background(color = Color(color = 0xFF072334))
                        .weight(weight = 0.4f)
                )
                Spacer(
                    modifier = Modifier
                        .weight(weight = 0.1f)
                )
                Text(
                    text = stringResource(R.string.candidateName),
                    color = Color.Black,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .weight(weight = 0.1f)
                )
                Text(
                    text = stringResource(R.string.candidatePosition),
                    color = Color(color = 0xFF06390E),
                    modifier = Modifier
                        .weight(weight = 0.1f)
                )
            }
        }
        Row(
            modifier = Modifier
                .weight(weight = 1f, fill = true)
                .padding(horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center

        ) {
            Spacer(
                modifier = Modifier
                    .weight(weight = 0.1f, fill = true)
            )
            Column(
                modifier = Modifier
                    .weight(weight = 0.5f, fill = true)
                    .padding(vertical = 12.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Icon(
                    imageVector = Icons.Rounded.Phone,
                    contentDescription = null,
                    tint = Color(color = 0xFF06390E),
                    modifier = Modifier.padding(vertical = 12.dp)
                )
                Icon(
                    imageVector = Icons.Rounded.Share,
                    contentDescription = null,
                    tint = Color(color = 0xFF06390E),
                    modifier = Modifier.padding(vertical = 12.dp)
                )
                Icon(
                    imageVector = Icons.Rounded.Email,
                    contentDescription = null,
                    tint = Color(color = 0xFF06390E),
                    modifier = Modifier.padding(vertical = 12.dp)
                )
            }
            Spacer(
                modifier = Modifier
                    .weight(weight = 0.01f, fill = true)
            )
            Column(
                modifier = Modifier
                    .weight(weight = 1f, fill = true),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Text(
                    text = stringResource(R.string.phoneNumber),
                    color = Color.Black,
                    modifier = Modifier
                        .padding(vertical = 12.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = stringResource(R.string.socialMedia),
                    color = Color.Black,
                    modifier = Modifier
                        .padding(vertical = 12.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = stringResource(R.string.email),
                    color = Color.Black,
                    modifier = Modifier
                        .padding(vertical = 12.dp)
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Business Card App Preview"
)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            BusinessCardApp(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}