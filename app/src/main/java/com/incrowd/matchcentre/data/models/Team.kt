package com.incrowd.matchcentre.data.models

import com.incrowd.matchcentre.data.match.models.stats.TeamStats

class Team(
    val id: String,
    val name: String,
    val shortName: String,
    val score: Int,
    val halfTimeScore: Int,
    val players: List<Player>,
    val teamStats: TeamStats,
    val imageUrl: String
) {
    fun getSecondHalfScore() = score - halfTimeScore
}