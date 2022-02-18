package com.incrowd.matchcentre.di.match

import com.incrowd.matchcentre.data.match.IMatchDataSource
import com.incrowd.matchcentre.data.match.IMatchRepository
import com.incrowd.matchcentre.data.match.MatchRepository
import com.incrowd.matchcentre.data.match.remote.MatchRemoteDataSource
import com.incrowd.matchcentre.domain.match.IMatchInteractor
import com.incrowd.matchcentre.domain.match.MatchInteractor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface MatchModules {
    @Binds
    fun bindMatchRemoteDataSource(matchRemoteDataSource: MatchRemoteDataSource): IMatchDataSource

    @Binds
    fun bindMatchInteractor(matchInteractor: MatchInteractor): IMatchInteractor

    @Binds
    fun bindMatchRepository(matchRepository: MatchRepository): IMatchRepository
}