package com.kotlinlearn.domain.repo

import com.kotlinlearn.domain.entity.CategoryResponse

interface MealsRepo {

    suspend fun getMealsFromRemote(): CategoryResponse
}