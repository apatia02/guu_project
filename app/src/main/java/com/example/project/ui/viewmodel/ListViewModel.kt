package com.example.project.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    val list = repository.getIncidents()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), emptyList())
}