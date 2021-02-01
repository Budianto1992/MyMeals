package com.budianto.mymeals.core.data.source.remote.response

import com.google.gson.annotations.SerializedName


data class MealResponse(

    @field:SerializedName("idMeal")
    val idMeal: String,

    @field:SerializedName("strMeal")
    val strMeal: String,

    @field:SerializedName("strInstructions")
    val strInstractions: String,

    @field:SerializedName("strMealThumb")
    val strMealThumb: String
)
