package com.budianto.mymeals.core.data.source.local

import com.budianto.mymeals.core.data.source.local.entity.MealEntity
import com.budianto.mymeals.core.data.source.local.room.MealDao

class LocalDataSouce (private val mealDao: MealDao){

    fun getAllMealsDb() = mealDao.getAllMealsDb()

    suspend fun insertMealDb(meals: List<MealEntity>) = mealDao.insertMealDb(meals)
}