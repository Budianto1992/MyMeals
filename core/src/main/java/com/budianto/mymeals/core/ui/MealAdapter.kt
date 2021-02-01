package com.budianto.mymeals.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.budianto.mymeals.core.R
import com.budianto.mymeals.core.databinding.ItemListMealBinding
import com.budianto.mymeals.core.domain.model.Meal
import com.bumptech.glide.Glide

class MealAdapter : RecyclerView.Adapter<MealAdapter.MyViewHolder>() {

    private var listData = ArrayList<Meal>()
    var onItemClick: ((Meal) -> Unit)? = null

    fun setData(newListData: List<Meal>?){
        if (newListData == null) return
        listData.clear()
        listData.addAll(listData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_meal, parent, false))

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = listData[position]
        holder.bindTo(data)
    }

    override fun getItemCount(): Int = listData.size

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val binding = ItemListMealBinding.bind(itemView)

        fun bindTo(data: Meal){
            with(binding){
                Glide.with(itemView.context)
                    .load(data.strMealThumb)
                    .into(ivItemImage)
                tvItemTitle.text = data.strMeal
                tvItemSubtitle.text = data.strInstractions
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}