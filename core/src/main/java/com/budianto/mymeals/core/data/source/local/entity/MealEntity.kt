package com.budianto.mymeals.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mealentities")
data class MealEntity(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idMeal")
    var idMeal: String,


    @ColumnInfo(name = "strMeal")
    var strMeal: String,

    @ColumnInfo(name = "strInstructions")
    var strInstractions: String,

    @ColumnInfo(name = "strMealThumb")
    var strMealThumb: String
)