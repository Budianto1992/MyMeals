package com.budianto.mymeals.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.budianto.mymeals.core.data.source.local.entity.MealEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface MealDao {

    @Query("SELECT * FROM mealentities")
    fun getAllMealsDb(): Flow<List<MealEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMealDb(meals: List<MealEntity>)
}