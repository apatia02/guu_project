package com.example.project.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface IncidentDao {

    @Query("SELECT * FROM incidents where exist = 1")
    fun getIncidents(): Flow<List<IncidentDto>>

    @Insert
    suspend fun newIncident(incidentDto: IncidentDto)

    @Query("UPDATE incidents set exist = 0 where id = :id")
    suspend fun doIncident(id: Int)
}