package com.budianto.mymeals.core.data

import com.budianto.mymeals.core.data.source.local.LocalDataSouce
import com.budianto.mymeals.core.data.source.remote.RemoteDataSource
import com.budianto.mymeals.core.data.source.remote.network.ApiResponse
import com.budianto.mymeals.core.data.source.remote.response.MealResponse
import com.budianto.mymeals.core.domain.model.Meal
import com.budianto.mymeals.core.domain.repository.IMealRepository
import com.budianto.mymeals.core.util.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MealRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSouce: LocalDataSouce,
) : IMealRepository {
    override fun getAllMeals(): Flow<Resource<List<Meal>>> =
        object : NetworkBoundResource<List<Meal>, List<MealResponse>>(){
            override fun loadFromDB(): Flow<List<Meal>> {
                return localDataSouce.getAllMealsDb().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }
            override fun shouldFetch(data: List<Meal>?): Boolean = true
            override suspend fun createCall(): Flow<ApiResponse<List<MealResponse>>> =
                remoteDataSource.getAllMeals()
            override suspend fun saveCallResult(data: List<MealResponse>) {
                val mealList = DataMapper.mapResponseToEntities(data)
                localDataSouce.insertMealDb(mealList)
            }

        }.asFlow()
}