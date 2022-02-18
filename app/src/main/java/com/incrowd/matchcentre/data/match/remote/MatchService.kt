package com.incrowd.matchcentre.data.match.remote

import com.incrowd.matchcentre.data.match.models.commentary.CommentaryResponse
import com.incrowd.matchcentre.data.match.models.stats.StatsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MatchService {

    @GET("/provider/opta/football/v1/matches/{id}/commentary")
    suspend fun getMatchCommentary(@Path("id") id: Long): CommentaryResponse

    @GET("/provider/opta/football/v1/matches/{id}")
    suspend fun getMatchStats(@Path("id") id: Long): StatsResponse
}