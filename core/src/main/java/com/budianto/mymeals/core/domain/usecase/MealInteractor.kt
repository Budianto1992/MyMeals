package com.budianto.mymeals.core.domain.usecase

import com.budianto.mymeals.core.data.Resource
import com.budianto.mymeals.core.domain.model.Meal
import com.budianto.mymeals.core.domain.repository.IMealRepository
import kotlinx.coroutines.flow.Flow

class MealInteractor(private val mealRepository: IMealRepository): MealUseCase {
    override fun getAllMeals(): Flow<Resource<List<Meal>>> = mealRepository.getAllMeals()
}