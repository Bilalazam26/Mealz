package com.kotlinlearn.data.repo

import com.kotlinlearn.data.remote.MealsApiService
import com.kotlinlearn.domain.entity.CategoryResponse
import com.kotlinlearn.domain.repo.MealsRepo

class MealsRepoImpl(private val mealsApiService: MealsApiService): MealsRepo {
    override suspend fun getMealsFromRemote(): CategoryResponse = mealsApiService.getMeals()

}