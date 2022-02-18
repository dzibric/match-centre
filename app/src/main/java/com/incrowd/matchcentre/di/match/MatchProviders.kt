package com.incrowd.matchcentre.di.match

import com.incrowd.matchcentre.data.match.remote.MatchService
import com.incrowd.matchcentre.utils.createService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MatchProviders {

    @Provides
    @Singleton
    fun provideMatchService(): MatchService {
        return createService(MatchService::class.java)
    }
}