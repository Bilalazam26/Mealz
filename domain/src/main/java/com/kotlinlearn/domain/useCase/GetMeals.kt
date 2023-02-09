package com.kotlinlearn.domain.useCase

import com.kotlinlearn.domain.repo.MealsRepo

class GetMeals(private val mealsRepo: MealsRepo) {

    //ال class فيه function واحده هتتنفذ اول ما انادي على ال class
    suspend operator fun invoke() = mealsRepo.getMealsFromRemote()
}