package com.incrowd.matchcentre.ui.main.stats

import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView
import com.incrowd.matchcentre.R
import com.incrowd.matchcentre.data.match.models.stats.StatsData
import com.incrowd.matchcentre.databinding.ItemStatsBinding

class StatsAdapter(gameStats: StatsData) : RecyclerView.Adapter<StatsAdapter.StatsViewHolder>() {

    private val items = StatsHelper.generateStatsModels(gameStats)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatsViewHolder {
        return StatsViewHolder(
            ItemStatsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: StatsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    class StatsViewHolder(binding: ItemStatsBinding) : RecyclerView.ViewHolder(binding.root) {
        private val homeStat = binding.tvHomeTeamStats
        private val awayStat = binding.tvAwayTeamStats
        private val homeProgress = binding.homeProgress
        private val awayProgress = binding.awayProgress
        private val statName = binding.tvStatsName
        private val context: Context = binding.root.context

        fun bind(statsModel: StatsModel) {
            homeStat.text =
                context.getString(R.string.stat, statsModel.homeStat, statsModel.addedSymbol)
            awayStat.text =
                context.getString(R.string.stat, statsModel.awayStat, statsModel.addedSymbol)
            val max = statsModel.homeStat + statsModel.awayStat
            homeProgress.max = max
            awayProgress.max = max
            homeProgress.progress = statsModel.homeStat
            awayProgress.progress = statsModel.awayStat
            statName.setText(statsModel.statName)
            setProgressColor(homeProgress, awayProgress)
        }

        private fun setProgressColor(homeProgress: ProgressBar, awayProgress: ProgressBar) {
            homeProgress.progressTintList =
                ColorStateList.valueOf(
                    if (homeProgress.progress > awayProgress.progress) context.getColor(R.color.colorSecondary)
                    else context.getColor(R.color.white)
                )
            awayProgress.progressTintList =
                ColorStateList.valueOf(
                    if (awayProgress.progress > homeProgress.progress) context.getColor(R.color.colorSecondary)
                    else context.getColor(R.color.white)
                )
        }
    }

    class StatsModel(
        @StringRes val statName: Int,
        val homeStat: Int,
        val awayStat: Int,
        val addedSymbol: String = ""
    )
}