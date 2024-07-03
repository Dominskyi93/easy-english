package com.easy.english.data.repository

import android.content.Context
import com.easy.english.data.WordTest
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import java.io.InputStream

private const val PATH = "fruits.json"

class FileReaderRepositoryImpl(
    private val moshi: Moshi,
    private val context: Context,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : FileReaderRepository {
    override suspend fun getAll(): List<WordTest> = withContext(dispatcher) {
        val type = Types.newParameterizedType(List::class.java, WordTest::class.java)
        val adapter = moshi.adapter<List<WordTest>>(type)
        try {
            val inputStream: InputStream = context.assets.open(PATH)
            val json = inputStream.bufferedReader().use { it.readText() }
            adapter.fromJson(json) ?: emptyList()
        } catch (e: IOException) {
            e.printStackTrace()
            emptyList()
        }
    }
}