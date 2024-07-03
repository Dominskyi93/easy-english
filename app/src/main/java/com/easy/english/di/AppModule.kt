package com.easy.english.di

import android.content.Context
import androidx.room.Room
import com.easy.english.data.repository.FileReaderRepository
import com.easy.english.data.repository.FileReaderRepositoryImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

private const val DATABASE_NAME = "db"

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
//    @Provides
//    fun provideDb(@ApplicationContext context: Context): Db {
//        return Room.databaseBuilder(
//            context,
//            Db::class.java,
//            DATABASE_NAME
//        ).build()
//    }

//    @Provides
//    fun provideProductDao(db: Db): CategoryDao {
//        return db.categoryDao()
//    }


    @Provides
    @Singleton
    fun getMoshiInstance(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    fun getRepoInstance(
        moshi: Moshi,
        @ApplicationContext context: Context
    ): FileReaderRepository = FileReaderRepositoryImpl(moshi, context)

    @Provides
    fun provideCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.IO
}