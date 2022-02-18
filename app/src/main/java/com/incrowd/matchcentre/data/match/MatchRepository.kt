package com.incrowd.matchcentre.data.match

import com.incrowd.matchcentre.data.match.models.commentary.CommentaryResponse
import com.incrowd.matchcentre.data.match.models.stats.StatsResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MatchRepository @Inject constructor(
    private val dataSource: IMatchDataSource
) : IMatchRepository {
    override suspend fun getMatchCommentary(id: Long): CommentaryResponse {
        return dataSource.getMatchCommentary(id)
    }

    override suspend fun getMatchStats(id: Long): StatsResponse {
        return dataSource.getMatchStats(id)
    }
}