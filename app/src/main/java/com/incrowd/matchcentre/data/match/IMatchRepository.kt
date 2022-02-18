package com.incrowd.matchcentre.data.match

import com.incrowd.matchcentre.data.match.models.commentary.CommentaryResponse
import com.incrowd.matchcentre.data.match.models.stats.StatsResponse

interface IMatchRepository {
    suspend fun getMatchCommentary(id: Long): CommentaryResponse
    suspend fun getMatchStats(id: Long): StatsResponse
}