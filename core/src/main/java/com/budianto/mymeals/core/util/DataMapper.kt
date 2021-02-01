package com.budianto.mymeals.core.util

import com.budianto.mymeals.core.data.source.local.entity.MealEntity
import com.budianto.mymeals.core.data.source.remote.response.MealResponse
import com.budianto.mymeals.core.domain.model.Meal

object DataMapper {
    fun mapResponseToEntities(input: List<MealResponse>): List<MealEntity> {
        val mealList = ArrayList<MealEntity>()
        input.map {
            val meal = MealEntity(
                idMeal = it.idMeal,
                strMeal = it.strMeal,
                strInstractions = it.strInstractions,
                strMealThumb = it.strMealThumb
            )
            mealList.add(meal)
        }
        return mealList
    }

    fun mapEntitiesToDomain(input: List<MealEntity>): List<Meal> =
        input.map {
            Meal(
                idMeal = it.idMeal,
                strMeal = it.strMeal,
                strInstractions = it.strInstractions,
                strMealThumb = it.strMealThumb
            )
        }

    fun mapDomainToEntitiy(input: Meal) = MealEntity(
        idMeal = input.idMeal,
        strMeal = input.strMeal,
        strInstractions = input.strInstractions,
        strMealThumb = input.strMealThumb
    )
}