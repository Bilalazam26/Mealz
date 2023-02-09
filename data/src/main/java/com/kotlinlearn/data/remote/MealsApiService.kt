package com.kotlinlearn.data.remote

import com.kotlinlearn.domain.entity.CategoryResponse
import retrofit2.http.GET

interface MealsApiService {

    @GET("categories.php")
    suspend fun getMeals(): CategoryResponse
}