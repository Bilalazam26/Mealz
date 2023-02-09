package com.kotlinlearn.mealz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kotlinlearn.mealz.viewModel.MealsViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlinlearn.domain.entity.Category
import com.kotlinlearn.domain.entity.CategoryResponse
import com.kotlinlearn.mealz.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel:MealsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getMeals()



        lifecycleScope.launch {
            viewModel.categories.collect {
                if (it != null) {
                    setRecyclerView(it.categories)
                }
            }
        }
    }

    private fun setRecyclerView(it: List<Category>) {
        val rv = binding.categoriesRv
        rv.layoutManager = LinearLayoutManager(this@MainActivity)
        val adapter = CategoryAdapter(this@MainActivity)
        rv.adapter = adapter
        adapter.setData(it as MutableList<Category>)
    }
}