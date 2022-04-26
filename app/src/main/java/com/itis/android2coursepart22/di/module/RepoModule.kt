package com.itis.android2coursepart22.di.module

import com.itis.android2coursepart22.data.repository.BrewRepositoryImpl
import com.itis.android2coursepart22.domain.repository.BrewRepository
import dagger.Binds
import dagger.Module

@Module
interface RepoModule {
    @Binds
    fun brewRepository(
        impl: BrewRepositoryImpl
    ): BrewRepository
}