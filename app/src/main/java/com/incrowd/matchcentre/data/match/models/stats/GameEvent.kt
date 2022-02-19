package com.incrowd.matchcentre.data.match.models.stats

import com.incrowd.matchcentre.R
import com.incrowd.matchcentre.utils.GOAL
import com.incrowd.matchcentre.utils.RED_CARD
import com.incrowd.matchcentre.utils.SUBSTITUTION
import com.incrowd.matchcentre.utils.YELLOW_CARD

data class GameEvent(
    val time: String,
    val period: String,
    val teamId: String,
    val type: String,
    val goalDetails: EventDetails?,
    val bookingDetails: EventDetails?,
    val substitutionDetails: SubstitutionDetails?
) {
    fun generateEventIcon(): Int {
        return when (type) {
            GOAL -> R.drawable.ic_football_56dp
            YELLOW_CARD -> R.drawable.yellow_card
            RED_CARD -> R.drawable.red_card
            SUBSTITUTION -> R.drawable.ic_substitution_56dp
            else -> throw IllegalStateException("Event type not handled")
        }
    }

    fun generateEventText(): String {
        return when (type) {
            GOAL -> goalDetails!!.player.getPlayerName()
            YELLOW_CARD, RED_CARD -> bookingDetails!!.player.getPlayerName()
            SUBSTITUTION -> "${substitutionDetails!!.playerSubOn.getPlayerName()} (${substitutionDetails.playerSubOff.getPlayerName()})"
            else -> throw IllegalStateException("Event type not handled")
        }
    }
}