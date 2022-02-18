package com.incrowd.matchcentre.data.match.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface MatchService {

    @GET("/football/v1/matches/{id}/commentary")
    fun getMatchCommentary(@Path("id") id: Long)

    @GET("/football/v1/matches/{id}")
    fun getMatchStats(@Path("id") id: Long)
}