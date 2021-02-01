package com.budianto.mymeals.core.data.source.remote

import android.util.Log
import com.budianto.mymeals.core.data.source.remote.network.ApiResponse
import com.budianto.mymeals.core.data.source.remote.network.ApiService
import com.budianto.mymeals.core.data.source.remote.response.MealResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource (private val apiService: ApiService){

    suspend fun getAllMeals(): Flow<ApiResponse<List<MealResponse>>>{
        return flow {

            try {
                val response = apiService.getAllMeals()
                val dataArray = response.meals

                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.meals))
                } else{
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception){
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}