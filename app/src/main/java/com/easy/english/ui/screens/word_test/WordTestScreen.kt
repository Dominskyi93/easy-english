package com.easy.english.ui.screens.word_test

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun WordTestScreen(viewModel: WordTestViewModel = hiltViewModel()) {
    val words by viewModel.words.collectAsState()
    LazyColumn {
        item {
            Column(modifier = Modifier.fillMaxSize()) {
                Text(text = words.toString())
            }
        }
    }

}