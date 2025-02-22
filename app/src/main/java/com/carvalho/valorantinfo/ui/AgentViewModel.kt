package com.carvalho.valorantinfo.ui

import Agent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carvalho.valorantinfo.data.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AgentViewModel : ViewModel() {
    private val repository = Repository()

    private val _agents = MutableStateFlow<List<Agent>>(emptyList())
    val agents: StateFlow<List<Agent>> = _agents

    fun fetchAgents() {
        viewModelScope.launch {
            val agentList = withContext(Dispatchers.IO) {
                repository.getAllAgent().getOrNull()
            }
            if (agentList != null) {
                _agents.value = agentList
            }
        }
    }

}
