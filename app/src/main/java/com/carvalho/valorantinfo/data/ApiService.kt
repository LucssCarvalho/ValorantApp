package com.carvalho.valorantinfo.data

import com.carvalho.valorantinfo.model.AgentResponse
import retrofit2.http.GET

interface ApiService {
    @GET("agents")
    suspend fun getAgents(): AgentResponse
}



