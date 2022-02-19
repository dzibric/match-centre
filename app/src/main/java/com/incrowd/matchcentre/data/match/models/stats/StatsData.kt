package com.incrowd.matchcentre.data.match.models.stats

import com.incrowd.matchcentre.data.models.Official
import com.incrowd.matchcentre.data.models.Team
import com.incrowd.matchcentre.data.models.Venue

data class StatsData(
    val id: String,
    val competition: String,
    val date: String,
    val homeTeam: Team,
    val awayTeam: Team,
    val attendance: Int?,
    val events: List<GameEvent>,
    val officials: List<Official>,
    val venue: Venue
) {
    fun getReferee(): Official {
        return officials.find { it.referee }!!
    }

    fun getStadium(): String {
        return "${venue.name} (${venue.location})"
    }
}