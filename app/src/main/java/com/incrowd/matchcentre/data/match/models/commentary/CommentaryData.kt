package com.incrowd.matchcentre.data.match.models.commentary

data class CommentaryData(
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
    val commentaryEntries: List<Commentary>
)