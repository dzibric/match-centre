package com.incrowd.matchcentre.data.models

import com.incrowd.matchcentre.data.match.models.stats.PlayerStats

class Player(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val known: String?,
    val position: String,
    val shirtNumber: Int,
    val status: String,
    val captain: Boolean,
    val playerStats: PlayerStats
) {
    fun getPlayerName(): String {
        return known ?: "$lastName ${firstName[0]}."
    }
}