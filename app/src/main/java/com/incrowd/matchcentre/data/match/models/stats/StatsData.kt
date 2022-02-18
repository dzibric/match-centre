package com.incrowd.matchcentre.data.match.models.stats

class StatsData(
    val id: String,
    val homeTeamName: String,
    val homeTeamId: String,
    val homeTeamImageUrl: String,
    val homeScore: Int,
    val awayTeamName: String,
    val awayTeamId: String,
    val awayTeamImageUrl: String,
    val awayScore: Int,
    val competition: String,
    val competitionEntries: List<>
) {
}