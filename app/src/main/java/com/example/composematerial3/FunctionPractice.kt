package com.example.composematerial3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composematerial3.ui.theme.ComposeMaterial3Theme

class FunctionPractice : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val username = intent.getStringExtra("name")
        val pass = intent.getStringExtra("pass")

        setContent {
            ComposeMaterial3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android", username.toString(), pass.toString())
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, username: String, pass: String) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(28.dp)
    ) {
        Text(text = "Hello $name!")


        showSimpleButton(
            context,
            modifier = Modifier
                .height(100.dp)
                .padding(16.dp)
                .background(Color.Transparent),
            name = "Click Here", color = Color.Gray
        ) {
            context.startActivity(
                Intent(
                    context,
                    GoogleActivity::class.java
                )
            )
            Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show()
        }
        showSimpleButton(
            context,
            modifier = Modifier
                .padding(16.dp)
                .background(Color.Transparent),
            name = "Click Here", color = Color.Blue
        ) {
            context.startActivity(
                Intent(
                    context,
                    GoogleActivity::class.java
                )
            )
        }
        Text(text = "Username: $username")
        Text(text = "Password: $pass")
    }
}

@Composable
fun showSimpleButton(
    context: Context,
    modifier: Modifier,
    name: String,
    color: Color,
    onClick: () -> Unit
) {
    Button(
        onClick = {
            onClick
        },
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(containerColor = color)
    ) {
        Text(
            text = name,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    ComposeMaterial3Theme {
        Greeting("Android", "USER", "PASSWORD")
    }
}