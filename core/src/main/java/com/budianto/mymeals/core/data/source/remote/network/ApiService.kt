package com.budianto.mymeals.core.data.source.remote.network

import com.budianto.mymeals.core.data.source.remote.response.ListMealResponse
import retrofit2.http.GET

interface ApiService {

    @GET("api/json/v1/1/search.php?f=a")
    suspend fun getAllMeals(): ListMealResponse
}