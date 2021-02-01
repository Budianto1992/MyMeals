package com.budianto.mymeals.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Meal(
    var idMeal: String,
    var strMeal: String,
    var strInstractions: String,
    var strMealThumb: String
) : Parcelable