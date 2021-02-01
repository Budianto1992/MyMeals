package com.budianto.mymeals.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.budianto.mymeals.ActivityHelper
import com.budianto.mymeals.core.domain.model.Meal
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_meals.*
import kotlinx.android.synthetic.main.content_detail_meals.*

class DetailMealsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_meals)

        val detailMapTourism = intent.getParcelableExtra<Meal>(ActivityHelper.Meals.EXTRA_DETAIL)
        showDataDetail(detailMapTourism)
    }


    private fun showDataDetail(meal: Meal?){
        meal?.let {
            supportActionBar?.title = meal.strMeal
            tv_detail_description.text = meal.strInstractions

            Glide.with(this@DetailMealsActivity)
                .load(meal.strMealThumb)
                .into(iv_detail_image)
        }
    }
}