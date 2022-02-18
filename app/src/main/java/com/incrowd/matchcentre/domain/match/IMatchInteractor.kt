package com.incrowd.matchcentre.domain.match

import com.incrowd.matchcentre.data.Result
import com.incrowd.matchcentre.data.match.models.commentary.CommentaryData
import com.incrowd.matchcentre.data.match.models.stats.StatsData

interface IMatchInteractor {
    suspend fun getMatchCommentary(id: Long): Result<CommentaryData>
    suspend fun getMatchStats(id: Long): Result<StatsData>
}