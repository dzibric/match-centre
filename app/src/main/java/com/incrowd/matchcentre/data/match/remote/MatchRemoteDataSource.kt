package com.incrowd.matchcentre.data.match.remote

import com.incrowd.matchcentre.data.match.IMatchDataSource
import com.incrowd.matchcentre.data.match.models.commentary.CommentaryResponse
import com.incrowd.matchcentre.data.match.models.stats.StatsResponse
import javax.inject.Inject

class MatchRemoteDataSource @Inject constructor(
    private val matchService: MatchService
) : IMatchDataSource {
    override suspend fun getMatchCommentary(id: Long): CommentaryResponse {
        return matchService.getMatchCommentary(id)
    }

    override suspend fun getMatchStats(id: Long): StatsResponse {
        return matchService.getMatchStats(id)
    }
}