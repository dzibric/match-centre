package com.incrowd.matchcentre.data.match.models.commentary

import com.incrowd.matchcentre.R
import com.incrowd.matchcentre.utils.*

data class Commentary(
    val type: String,
    val comment: String,
    val period: Int,
    val time: String?
) {

    fun getCommentaryIcon(): Int? {
        return when (type) {
            GOAL.lowercase() -> {
                R.drawable.ic_football_56dp
            }
            OFFSIDE.lowercase() -> {
                R.drawable.ic_offside_56dp
            }
            SUBSTITUTION.lowercase() -> {
                R.drawable.ic_substitution_56dp
            }
            START, END_1, END_2, END_14 -> {
                R.drawable.ic_whistle_56dp
            }
            START_DELAY -> {
                R.drawable.ic_delay_56dp
            }
            else -> null
        }
    }
}