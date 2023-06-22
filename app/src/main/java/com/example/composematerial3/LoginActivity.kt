package com.example.composematerial3

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composematerial3.ui.theme.ComposeMaterial3Theme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMaterial3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.off_white)
//                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreenUI()
                }
            }
        }
    }
}

@Composable
fun LoginScreenUI() {

    var passwordVisible by remember {
        mutableStateOf(false)
    }
    var text by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var extraEdit by remember { mutableStateOf("") }
    val context = LocalContext.current

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
                    label = { Text("Enter Name") },
                    trailingIcon = {
                        IconButton(onClick = { /* handle icon click */ }) {
                            Icon(
                                painter = painterResource(R.drawable.user),
                                contentDescription = "Icon",
                                modifier = Modifier
                                    .size(22.dp)
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
                    value = pass,
                    onValueChange = { pass = it },
                    label = { Text("Enter Password") },
                    trailingIcon = {
                        IconButton(onClick = {
                            passwordVisible = !passwordVisible
                        }) {
                            Icon(
                                painter = painterResource(
                                    if (passwordVisible) R.drawable.hide else R.drawable.show
                                ),
                                contentDescription = if (passwordVisible) "Hide Password" else "Show Password",
                                modifier = Modifier
                                    .size(22.dp)
                            )
                        }
                    },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
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
                val yellowD = Color(android.graphics.Color.parseColor("#FFD653"))

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
                        checkedTrackColor = yellowD,
                        uncheckedTrackColor = Color.Black,
                        checkedIconColor = MaterialTheme.colorScheme.background
                    )
                )
            }
            Button(
                onClick = {
                    context.startActivity(
                        Intent(
                            context,
                            FunctionPractice::class.java
                        ).putExtra("name", text).putExtra("pass", pass)
                    )
                },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .background(Color.Transparent),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            ) {
                Text(text = "LOG IN")
            }
            /*   TextFieldWithBackground(modifier = Modifier
                   .fillMaxWidth()
                   .height(56.dp),
                   R.drawable.text_fill_background, "Enter Text", onTextChange = { newText ->
                       extraEdit = newText
                   })*/
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth(0.45f)
                        .padding(0.dp, 0.dp, 4.dp, 0.dp)
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    colorResource(id = R.color.off_white),
                                    Color.White
                                )
                            )
                        )
                ) {
                    Divider(color = Color.Transparent, thickness = 0.dp)
                }
                Text(text = "OR")
                Box(
                    modifier = Modifier
                        .height(1.dp)
                        .padding(4.dp, 0.dp, 0.dp, 0.dp)
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    Color.White,
                                    colorResource(id = R.color.off_white)
                                )
                            )
                        )
                ) {
                    Divider(color = Color.Transparent, thickness = 0.dp)
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                SquareButtonWithImage(imageResId = R.drawable.icon_google,
                    onClick = {
                        Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();
                    }
                )
                SquareButtonWithImage(imageResId = R.drawable.icon_facebook,
                    onClick = {
                        Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();
                    }
                )
                SquareButtonWithImage(imageResId = R.drawable.icon_instagram,
                    onClick = {
                        Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();
                    }
                )
                SquareButtonWithImage(imageResId = R.drawable.icon_twitter,
                    onClick = {
                        Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();
                    }
                )
                SquareButtonWithImage(imageResId = R.drawable.icon_apple,
                    onClick = {
                        Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();
                    }
                )

            }
        }
    }
}

@Composable
fun SquareButtonWithImage(
    imageResId: Int,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(64.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable(onClick = onClick)
            .border(width = 2.dp, color = Color.White)
            .background(colorResource(id = R.color.off_white))
            .padding(4.dp),
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxSize()
        )
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