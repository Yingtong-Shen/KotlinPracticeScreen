package com.example.kotlinpracticescreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlinpracticescreen.ui.theme.KotlinPracticeScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinPracticeScreenTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    KotlinPracticeScreen()
                }
            }
        }
    }
}

/**
 * when expression: Display different results based on the input string (cat/dog/fish/...)
 * ?.let: Display a message only if the nullable string is not null
 * - Counter: only increment when less than 5
 */
@Composable
fun KotlinPracticeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Use when，create input and give a result based on the input
        var input by remember { mutableStateOf("") }
        val result = when {
            input.isNotEmpty() -> "You just type $input"
            else -> "Please enter something"
        }
        Text(text = result)

        // Analog input (button control)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { input = "cat" })  { Text("cat") }
            Button(onClick = { input = "dog" })  { Text("dog") }
            Button(onClick = { input = "fish" }) { Text("fish") }
            Button(onClick = { input = "" })  { Text("clear") }
        }

        // ?.let
        var nullableMsg by remember { mutableStateOf<String?>(null) }
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { nullableMsg = "Hi" }) { Text("Set message") }
            Button(onClick = { nullableMsg = null })                { Text("Clear") }
        }
        nullableMsg?.let { Text(text = it) }

        // Counter <5
        var counter by remember { mutableIntStateOf(0) }
        Text(text = "Counter: $counter")
        Button(
            onClick = { if (counter < 5) counter++ },
        ) { Text("+1 (Only work <5)") }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinPracticeScreenTheme {
        KotlinPracticeScreen()
    }
}