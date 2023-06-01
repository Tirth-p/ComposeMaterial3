package com.example.composematerial3

import android.content.res.Configuration
import android.os.Bundle
import android.view.RoundedCorner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composematerial3.ui.theme.ComposeMaterial3Theme
import com.google.android.material.color.utilities.MaterialDynamicColors.background

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMaterial3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreenUI()
                }
            }
        }
    }
}

@Composable
fun LoginScreenUI() {

    var text by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.padding(28.dp)
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.spotify_icon_dark),
                    contentDescription = "Spotify Logo",
                    modifier = Modifier
                        .size(50.dp)
                        .padding(0.dp, 0.dp, 10.dp, 10.dp)
                )
                Text(
                    text = "Spotify",
                    fontSize = 28.sp,
                    fontFamily = FontFamily.Cursive

                )
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Log in to continue.",
                    fontSize = 27.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold
                )
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Enter text") },
                    trailingIcon = {
                        IconButton(onClick = { /* handle icon click */ }) {
                            Icon(
                                painter = painterResource(R.drawable.ic_mail),
                                contentDescription = "Icon"
                            )
                        }
                    }
                )
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Enter Password") },
                    trailingIcon = {
                        IconButton(onClick = { /* handle icon click */ }) {
                            Icon(
                                painter = painterResource(R.drawable.ic_mail),
                                contentDescription = "Icon"
                            )
                        }
                    }
                )
            }

            Row(
                modifier = Modifier
                    .padding(15.dp, 10.dp, 0.dp, 0.dp)
            ) {
                Text(text = "Reset Password")
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp, 10.dp, 0.dp, 0.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Remember Me",
                    modifier = Modifier.weight(1f)
                )

                val switchState = remember { mutableStateOf(false) }
                val YellowD = Color(android.graphics.Color.parseColor("#FFD653"))

                Switch(
                    checked = switchState.value,
                    onCheckedChange = { switchState.value = it },
                    modifier = Modifier
                        .scale(0.55f) // Adjust the scale factor as per your requirement
                        .padding(4.dp),
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = MaterialTheme.colorScheme.inverseSurface,
                        uncheckedThumbColor = Color.White,
                        checkedBorderColor = Color.Black,
                        uncheckedBorderColor = Color.White,
                        checkedTrackColor = YellowD,
                        uncheckedTrackColor = Color.Black,
                        checkedIconColor = MaterialTheme.colorScheme.background
                    )
                )
            }
            Button(
                onClick = { /* Handle button click here */ },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .background(Color.White),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            ) {
                Text(text = "LOG IN")
            }
            TextFieldWithBackground(modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            R.drawable.text_fill_background,"Enter Text", onTextChange = { newText ->
                    text = newText
                })

        }
    }
}

@Composable
fun TextFieldWithBackground(
    modifier: Modifier = Modifier,
    backgroundImageRes: Int,
    text: String,
    onTextChange: (String) -> Unit
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(backgroundImageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        var textFieldValue by remember { mutableStateOf(text) }
        BasicTextField(
            value = textFieldValue,
            onValueChange = {
                textFieldValue = it
                onTextChange(it)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark Mode"
)
@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ComposeMaterial3Theme {
        LoginScreenUI()
    }
}