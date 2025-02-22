package com.carvalho.valorantinfo.model

import Agent

data class AgentResponse(
    val status: Int,
    val data: List<Agent>
)
