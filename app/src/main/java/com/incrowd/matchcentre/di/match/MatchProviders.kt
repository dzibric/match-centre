package com.incrowd.matchcentre.di.match

import com.incrowd.matchcentre.data.AppDatabase
import com.incrowd.matchcentre.data.match.local.PlayerDao
import com.incrowd.matchcentre.data.match.local.TeamDao
import com.incrowd.matchcentre.data.match.remote.MatchService
import com.incrowd.matchcentre.utils.createRestClient
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
        return createRestClient(MatchService::class.java)
    }

    @Provides
    @Singleton
    fun provideTeamDao(appDatabase: AppDatabase): TeamDao {
        return appDatabase.teamDao()
    }

    @Provides
    @Singleton
    fun providePlayerDao(appDatabase: AppDatabase): PlayerDao {
        return appDatabase.playerDao()
    }
}