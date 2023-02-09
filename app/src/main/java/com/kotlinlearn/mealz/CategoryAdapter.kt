package com.kotlinlearn.mealz

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kotlinlearn.domain.entity.Category
import com.kotlinlearn.mealz.databinding.CategoryLayoutBinding

class CategoryAdapter(private val context: Context?) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private var categoryList: MutableList<Category> = mutableListOf<Category>()

    inner class CategoryViewHolder(itemView: CategoryLayoutBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        val name = itemView.categoryNameTv
        val img = itemView.categoryIv
        val des = itemView.categoryDesTv
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = CategoryLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        var category = categoryList[position]
        holder.name.text = category.strCategory
        holder.des.text = category.strCategoryDescription
        Glide.with(context as Context).load(category.strCategoryThumb).into(holder.img)
        Log.d("MMMM", "onBindViewHolder: $itemCount")
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    fun setData(categoryList: MutableList<Category>) {
        this.categoryList.addAll(categoryList)
        notifyDataSetChanged() //to notify adapter that new data change has been happened to adapt it
    }
}