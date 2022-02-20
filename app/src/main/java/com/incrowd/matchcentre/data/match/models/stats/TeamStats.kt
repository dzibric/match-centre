package com.incrowd.matchcentre.data.match.models.stats

data class TeamStats(
    val formation: String,
    val cornersWon: Int,
    val shotsOnGoal: Int,
    val shotsOnTarget: Int,
    val shotsOffTarget: Int,
    val shotsBlocked: Int,
    val freeKicksWon: Int,
    val teamYellowCards: Int,
    val throwIns: Int,
    val saves: Int,
    val goals: Int,
    val possession: Double
)