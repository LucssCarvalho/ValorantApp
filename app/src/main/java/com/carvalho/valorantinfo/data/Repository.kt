package com.carvalho.valorantinfo.data

import android.util.Log
import com.carvalho.valorantinfo.model.Agent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class Repository {
    suspend fun getAllAgent(): Result<List<Agent>> {
        return try {
            val response = withContext(Dispatchers.IO) {
                RetrofitInstance.api.getAgents()
            }
            Result.success(response.data)
        } catch (e: HttpException) {
            Log.e("Repository", "HTTP error ${e.code()}: ${e.message()}")
            Result.failure(e)
        } catch (e: Exception) {
            Log.e("Repository", "Error fetching agents: ${e.message}", e)
            Result.failure(e)
        }
    }
}

