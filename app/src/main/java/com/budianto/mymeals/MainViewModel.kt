package com.budianto.mymeals

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.budianto.mymeals.core.domain.usecase.MealUseCase

class MainViewModel(mealUseCase: MealUseCase): ViewModel() {
    val meals = mealUseCase.getAllMeals().asLiveData()
}