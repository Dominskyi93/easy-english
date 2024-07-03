package com.easy.english.data.repository

import com.easy.english.data.WordTest

interface FileReaderRepository {
    suspend fun getAll(): List<WordTest>

}