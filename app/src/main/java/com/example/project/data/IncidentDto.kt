package com.example.project.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "incidents")
data class IncidentDto(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val corpus: String,
    val room: String,
    val category: String,
    val description: String,
    val exist: Int
)