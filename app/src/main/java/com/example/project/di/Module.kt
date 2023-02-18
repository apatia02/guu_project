package com.example.project.di

import android.content.Context
import androidx.room.Room
import com.example.project.data.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) = Room
        .databaseBuilder(context, AppDatabase::class.java, "incidents")
        .build()

    @Singleton
    @Provides
    fun provideDao(db: AppDatabase) = db.incidentDao()
}