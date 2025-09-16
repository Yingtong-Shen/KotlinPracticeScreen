package com.example.colorcardfunction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.colorcardfunction.ui.theme.ColorCardFunctionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColorCardFunctionTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    ColorCardFunction()
                }
            }
        }
    }
}

/**
 * Displays a card with a background color and with label in the center.
 * Uses: padding / background / border / size
 */
@Composable
fun ColorCard(color: Color, label: String, modifier: Modifier = Modifier) {
    val shape = RectangleShape
    Box(
        modifier = modifier
            .size(width = 90.dp, height = 140.dp)
            .border(width = 5.dp, color = Color.Black, shape = shape)
            .padding(5.dp)
            .background(color = color, shape = shape),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = label,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

/**
 * Show three cards of different colors
 */
@Composable
fun ColorCardFunction() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ColorCard(
            color = Color.Red,
            label = "Red"
        )

        ColorCard(
            color = Color.Blue,
            label = "Blue",
            modifier = Modifier
                .size(110.dp, 180.dp)
                .border(7.dp, Color.Red, RectangleShape)
        )

        Box(modifier = Modifier.padding(horizontal = 32.dp)) {
            ColorCard(
                color = Color.Green,
                label = "Green",
                modifier = Modifier
                    .border(5.dp,Color.Cyan, RectangleShape)
                    .padding(10.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MaterialTheme{ColorCardFunction()}
}