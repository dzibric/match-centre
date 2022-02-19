package com.incrowd.matchcentre.ui.main.details

import com.incrowd.matchcentre.R
import com.incrowd.matchcentre.data.match.models.stats.StatsData
import com.incrowd.matchcentre.utils.FIRST_HALF
import com.incrowd.matchcentre.utils.SECOND_HALF
import com.incrowd.matchcentre.utils.formatNumber

object DetailsHelper {
    fun generateItems(gameStats: StatsData): List<DetailsAdapter.DetailsModel> {
        val items = mutableListOf<DetailsAdapter.DetailsModel>()
        fun insertEvents(period: String) {
            gameStats.events.filter { it.period == period }.forEach { event ->
                //Is event from home team
                if (event.teamId == gameStats.homeTeam.id) {
                    items.add(DetailsAdapter.HomeEventModel(event))
                } else {
                    items.add(DetailsAdapter.AwayEventModel(event))
                }
            }
        }
        //First half header
        items.add(
            DetailsAdapter.GameHalfModel(
                1,
                gameStats.homeTeam.halfTimeScore,
                gameStats.awayTeam.halfTimeScore
            )
        )
        //First half events
        insertEvents(FIRST_HALF)
        //Second half header
        items.add(
            DetailsAdapter.GameHalfModel(
                2,
                gameStats.homeTeam.getSecondHalfScore(),
                gameStats.awayTeam.getSecondHalfScore()
            )
        )
        //Second half events
        insertEvents(SECOND_HALF)

        //Info
        items.add(DetailsAdapter.InfoHeaderModel())
        items.add(DetailsAdapter.GameInfoModel(R.string.referee, gameStats.getReferee().name))
        items.add(DetailsAdapter.GameInfoModel(R.string.stadium, gameStats.getStadium()))
        gameStats.attendance?.let {
            items.add(
                DetailsAdapter.GameInfoModel(
                    R.string.attendance,
                    it.formatNumber()
                )
            )
        }

        return items
    }
}