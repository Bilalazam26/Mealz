package com.kotlinlearn.mealz.di

import com.kotlinlearn.data.remote.MealsApiService
import com.kotlinlearn.data.repo.MealsRepoImpl
import com.kotlinlearn.domain.repo.MealsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideRepo(mealsApiService: MealsApiService): MealsRepo {
        return MealsRepoImpl(mealsApiService)
    }
}