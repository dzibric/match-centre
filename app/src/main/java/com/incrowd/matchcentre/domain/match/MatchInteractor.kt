package com.incrowd.matchcentre.domain.match

import com.incrowd.matchcentre.data.Result
import com.incrowd.matchcentre.data.match.IMatchRepository
import com.incrowd.matchcentre.data.match.models.commentary.CommentaryData
import com.incrowd.matchcentre.data.match.models.stats.StatsData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MatchInteractor @Inject constructor(
    private val matchRepository: IMatchRepository
) : IMatchInteractor {
    override suspend fun getMatchCommentary(id: Long): Result<CommentaryData> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                Result.Success(matchRepository.getMatchCommentary(id).commentaryData)
            } catch (exc: Exception) {
                Result.Error(exc)
            }
        }

    override suspend fun getMatchStats(id: Long): Result<StatsData> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                Result.Success(matchRepository.getMatchStats(id).statsData)
            } catch (exc: Exception) {
                Result.Error(exc)
            }
        }
}