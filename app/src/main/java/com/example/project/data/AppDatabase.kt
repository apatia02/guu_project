package com.example.project.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [IncidentDto::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun incidentDao(): IncidentDao
}