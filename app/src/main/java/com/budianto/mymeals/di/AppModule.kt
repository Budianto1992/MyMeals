package com.budianto.mymeals.di

import com.budianto.mymeals.MainViewModel
import com.budianto.mymeals.core.domain.usecase.MealInteractor
import com.budianto.mymeals.core.domain.usecase.MealUseCase
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val useCaseModule = module {
    factory<MealUseCase> { MealInteractor(get()) }
}

val viewModelModule = module {
    viewModel{ MainViewModel(get()) }
}