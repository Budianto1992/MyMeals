package com.budianto.mymeals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.budianto.mymeals.core.data.Resource
import com.budianto.mymeals.core.ui.MealAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_error.view.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mealAdapter = MealAdapter()
        mealAdapter.onItemClick = { selectedData ->
            val intent = Intent()
            intent.putExtra(ActivityHelper.Meals.EXTRA_DETAIL, selectedData)
            intent.setClassName(ActivityHelper.PACKAGE_NAME, ActivityHelper.Meals.EXTRA_DETAIL)
            startActivity(intent)
        }

        mainViewModel.meals.observe(this, { meals ->
            if (meals != null){
                when(meals){
                    is Resource.Loading -> progress_bar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        progress_bar.visibility = View.GONE
                        mealAdapter.setData(meals.data)
                    }

                    is Resource.Error -> {
                        progress_bar.visibility = View.GONE
                        view_error.visibility = View.VISIBLE
                        view_error.tv_error.text = meals.message ?: getString(R.string.something_wrong)
                    }
                }
            }
        })

        with(rv_meal) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = mealAdapter
        }
    }
}