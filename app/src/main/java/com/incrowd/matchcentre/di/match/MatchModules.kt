package com.incrowd.matchcentre.di.match

import com.incrowd.matchcentre.Local
import com.incrowd.matchcentre.Remote
import com.incrowd.matchcentre.data.match.IMatchDataSource
import com.incrowd.matchcentre.data.match.local.MatchLocalDataSource
import com.incrowd.matchcentre.data.match.remote.MatchRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface MatchModules {

    @Remote
    @Binds
    fun getMatchRemoteDataSource(matchRemoteDataSource: MatchRemoteDataSource): IMatchDataSource

    @Local
    @Binds
    fun getMatchLocalDataSource(matchLocalDataSource: MatchLocalDataSource): IMatchDataSource
}