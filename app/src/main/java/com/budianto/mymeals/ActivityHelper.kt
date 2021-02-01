package com.budianto.mymeals

interface AddressableActivity{

    val className: String
}

object ActivityHelper {

    const val PACKAGE_NAME = "com.budianto.mymeals"


    object Meals : AddressableActivity{
        override val className = "$PACKAGE_NAME.detail.DetailMealsActivity"

        const val EXTRA_DETAIL = "Detail"
    }
}