package com.budianto.mymeals.core.domain.usecase

import com.budianto.mymeals.core.data.Resource
import com.budianto.mymeals.core.domain.model.Meal
import kotlinx.coroutines.flow.Flow

interface MealUseCase {
    fun getAllMeals(): Flow<Resource<List<Meal>>>
}