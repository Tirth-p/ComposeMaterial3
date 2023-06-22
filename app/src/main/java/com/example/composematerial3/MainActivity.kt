package com.example.composematerial3

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composematerial3.ui.theme.ComposeMaterial3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMaterial3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MessageCard(Message("Tirth", "MainRunner"))
                }
            }
        }
    }
}

data class Message(val name: String, val author: String)


@Composable
fun MessageCard(msg: Message) {

    val checkedState = remember { mutableStateOf(false) }
    val switchState = remember { mutableStateOf(false) }
    val radioState = remember { mutableStateOf(false) }
    val radioOptions = listOf("A", "B", "C")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[1]) }
    val context = LocalContext.current

    Column {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(15.dp)
                .shadow(10.dp)
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Something",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        text = msg.name,
                        color = MaterialTheme.colorScheme.secondary
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = msg.author)
                }
            }
        }
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .padding(15.dp)
        ) {

            Button(onClick = {
                context.startActivity(Intent(context,LoginActivity::class.java))
            }) {
                Text(text = "ClickHere")
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Checkbox(
                checked = checkedState.value,
                modifier = Modifier
                    .padding(16.dp)
                    .size(10.dp),
                onCheckedChange = { checkedState.value = it }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Check Box Example")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Switch(
                checked = switchState.value,
                onCheckedChange = { switchState.value = it },
                modifier = Modifier.padding(12.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Switch Button")
        }
        Column {
            radioOptions.forEach { text ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = (text == selectedOption),
                            onClick = {
                                onOptionSelected(text)
                            }
                        )
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) }
                    )
                    Text(
                        text = text,
                        style = MaterialTheme.typography.bodySmall.merge(),
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }
        FloatingActionButton(
            onClick = { /*TODO*/ },
            contentColor = Color.Green,
            modifier = Modifier
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_add),
                contentDescription = "Add"
            )
        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeMaterial3Theme {
        MessageCard(Message("Tirth", "MainRunner"))
    }
}