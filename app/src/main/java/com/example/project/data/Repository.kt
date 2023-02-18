package com.example.project.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(private val dao: IncidentDao)  {

     fun getIncidents(): Flow<List<IncidentDto>> {

        return dao.getIncidents()


    }

     suspend fun newIncident(incident:IncidentDto) {
        dao.newIncident(incident)
    }

     suspend fun doIncident(id: Int) {
        dao.doIncident(id)
    }
}