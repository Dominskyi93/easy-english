package com.easy.english.ui.screens.word_test

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.easy.english.data.WordTest
import com.easy.english.data.repository.FileReaderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WordTestViewModel @Inject constructor(
    private val repository: FileReaderRepository
) : ViewModel() {
    private val _words = MutableStateFlow<List<WordTest>>(emptyList())
    val words: StateFlow<List<WordTest>> = _words

    init {
        getAll()
    }
    fun getAll() {
        viewModelScope.launch {
            _words.value = repository.getAll()
        }
    }
}