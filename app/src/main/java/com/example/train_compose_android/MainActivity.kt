package com.example.train_compose_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                var count by rememberSaveable { mutableIntStateOf(0) }
                ValueCounter(count)
                Row {
                    ButtonAction(onClick = { if (count > 0) count-- }, action = "-")
                    ButtonAction(onClick = { if (count < 10) count++ }, action = "+")
                }
            }
        }
    }
}

@Composable
fun ValueCounter(count: Int) {
    Text(text = "Count: $count")
}

@Composable
fun ButtonAction(onClick: () -> Unit, action: String) {
    Button(onClick = onClick) {
        Text(text = action)
    }
}
