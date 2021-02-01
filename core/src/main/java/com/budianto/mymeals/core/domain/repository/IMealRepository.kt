package com.budianto.mymeals.core.domain.repository

import com.budianto.mymeals.core.data.Resource
import com.budianto.mymeals.core.domain.model.Meal
import kotlinx.coroutines.flow.Flow

interface IMealRepository {

    fun getAllMeals(): Flow<Resource<List<Meal>>>
}