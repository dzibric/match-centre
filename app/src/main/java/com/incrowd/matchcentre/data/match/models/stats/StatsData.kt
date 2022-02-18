package com.incrowd.matchcentre.data.match.models.stats

import com.incrowd.matchcentre.data.models.Team

class StatsData(
    val id: String,
    val competition: String,
    val date: String,
    val homeTeam: Team,
    val awayTeam: Team
)