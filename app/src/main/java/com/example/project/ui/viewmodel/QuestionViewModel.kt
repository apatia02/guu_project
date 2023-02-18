package com.example.project.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project.data.IncidentDto
import com.example.project.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    fun newIncident(incident: IncidentDto) {
        viewModelScope.launch {
            repository.newIncident(incident)
        }
    }
}