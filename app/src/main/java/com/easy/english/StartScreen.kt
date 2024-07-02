package com.easy.english

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination

@Destination(start = true)
@Composable
fun StartScreen() {
    Text(text = "Hello english")
}