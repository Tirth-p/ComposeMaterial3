package com.example.composematerial3

import android.os.Build
import android.os.Bundle
import android.system.Os.remove
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.example.composematerial3.ui.theme.ComposeMaterial3Theme

class GoogleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val text = intent.getStringExtra("name")

        setContent {
            ComposeMaterial3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2(text.toString())
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Column (horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Hello $name!")

        Image(
            painter = painterResource(id = if (name == "Google") R.drawable.icon_google else if (name == "Facebook") R.drawable.icon_facebook else if (name == "Twitter") R.drawable.icon_twitter else if (name == "Instagram") R.drawable.icon_instagram else R.drawable.icon_apple),
            contentDescription = "$name resource",
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    ComposeMaterial3Theme {
        Greeting2("Android")
    }
}