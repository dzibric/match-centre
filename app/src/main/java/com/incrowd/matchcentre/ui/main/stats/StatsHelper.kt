package com.incrowd.matchcentre.ui.main.stats

import com.incrowd.matchcentre.R
import com.incrowd.matchcentre.data.match.models.stats.StatsData
import com.incrowd.matchcentre.data.match.models.stats.TeamStats
import com.incrowd.matchcentre.ui.main.stats.StatsAdapter.StatsModel
import kotlin.math.roundToInt

object StatsHelper {
    fun generateStatsModels(gameStats: StatsData): List<StatsModel> {
        val homeTeamStats = gameStats.homeTeam.teamStats
        val awayTeamStats = gameStats.awayTeam.teamStats
        return listOf(
            generatePossessionModel(homeTeamStats, awayTeamStats),
            generateShotsModel(homeTeamStats, awayTeamStats),
            generateOnTargetShotsModel(homeTeamStats, awayTeamStats),
            generateOffTargetShotsModel(homeTeamStats, awayTeamStats),
            generateBlockedShotsModel(homeTeamStats, awayTeamStats),
            generateFreeKicksModel(homeTeamStats, awayTeamStats),
            generateCornersModel(homeTeamStats, awayTeamStats),
            generateThrowInsModel(homeTeamStats, awayTeamStats),
            generateSavesModel(homeTeamStats, awayTeamStats),
            generateYellowCardsModel(homeTeamStats, awayTeamStats),
        )
    }

    private fun generatePossessionModel(
        homeTeamStats: TeamStats,
        awayTeamStats: TeamStats
    ): StatsModel {
        return StatsModel(
            R.string.possession,
            homeTeamStats.possession.roundToInt(),
            awayTeamStats.possession.roundToInt(),
            "%"
        )
    }

    private fun generateShotsModel(
        homeTeamStats: TeamStats,
        awayTeamStats: TeamStats
    ): StatsModel {
        return StatsModel(
            R.string.shots,
            homeTeamStats.shotsOnGoal,
            awayTeamStats.shotsOnGoal
        )
    }

    private fun generateOnTargetShotsModel(
        homeTeamStats: TeamStats,
        awayTeamStats: TeamStats
    ): StatsModel {
        return StatsModel(
            R.string.shots_on_target,
            homeTeamStats.shotsOnTarget,
            awayTeamStats.shotsOnTarget
        )
    }

    private fun generateOffTargetShotsModel(
        homeTeamStats: TeamStats,
        awayTeamStats: TeamStats
    ): StatsModel {
        return StatsModel(
            R.string.shots_off_target,
            homeTeamStats.shotsOffTarget,
            awayTeamStats.shotsOffTarget
        )
    }

    private fun generateBlockedShotsModel(
        homeTeamStats: TeamStats,
        awayTeamStats: TeamStats
    ): StatsModel {
        return StatsModel(
            R.string.shots_blocked,
            homeTeamStats.shotsBlocked,
            awayTeamStats.shotsBlocked
        )
    }

    private fun generateFreeKicksModel(
        homeTeamStats: TeamStats,
        awayTeamStats: TeamStats
    ): StatsModel {
        return StatsModel(
            R.string.free_kicks,
            homeTeamStats.freeKicksWon,
            awayTeamStats.freeKicksWon
        )
    }

    private fun generateCornersModel(
        homeTeamStats: TeamStats,
        awayTeamStats: TeamStats
    ): StatsModel {
        return StatsModel(
            R.string.corners,
            homeTeamStats.cornersWon,
            awayTeamStats.cornersWon
        )
    }

    private fun generateThrowInsModel(
        homeTeamStats: TeamStats,
        awayTeamStats: TeamStats
    ): StatsModel {
        return StatsModel(
            R.string.throw_ins,
            homeTeamStats.throwIns,
            awayTeamStats.throwIns
        )
    }

    private fun generateSavesModel(
        homeTeamStats: TeamStats,
        awayTeamStats: TeamStats
    ): StatsModel {
        return StatsModel(
            R.string.saves,
            homeTeamStats.saves,
            awayTeamStats.saves
        )
    }

    private fun generateYellowCardsModel(
        homeTeamStats: TeamStats,
        awayTeamStats: TeamStats
    ): StatsModel {
        return StatsModel(
            R.string.yellow_cards,
            homeTeamStats.teamYellowCards,
            awayTeamStats.teamYellowCards
        )
    }
}