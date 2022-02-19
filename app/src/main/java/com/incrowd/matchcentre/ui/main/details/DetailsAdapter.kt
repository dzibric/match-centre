package com.incrowd.matchcentre.ui.main.details

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView
import com.incrowd.matchcentre.R
import com.incrowd.matchcentre.data.match.models.stats.GameEvent
import com.incrowd.matchcentre.data.match.models.stats.StatsData
import com.incrowd.matchcentre.databinding.*
import com.incrowd.matchcentre.utils.FIRST_HALF
import com.incrowd.matchcentre.utils.SECOND_HALF
import com.incrowd.matchcentre.utils.formatNumber

class DetailsAdapter(gameStats: StatsData) :
    RecyclerView.Adapter<DetailsAdapter.DetailsViewHolder>() {

    companion object {
        private const val VIEW_TYPE_GAME_HALF = 1
        private const val VIEW_TYPE_HOME_EVENT = 2
        private const val VIEW_TYPE_AWAY_EVENT = 3
        private const val VIEW_TYPE_INFO_HEADER = 4
        private const val VIEW_TYPE_INFO = 5
    }

    private var items: List<DetailsModel>

    init {
        val items = mutableListOf<DetailsModel>()
        items.add(
            GameHalf(
                1,
                gameStats.homeTeam.halfTimeScore,
                gameStats.awayTeam.halfTimeScore
            )
        )
        gameStats.events.filter { it.period == FIRST_HALF }.forEach { event ->
            //Is event from home team
            if (event.teamId == gameStats.homeTeam.id) {
                items.add(HomeEvent(event))
            } else {
                items.add(AwayEvent(event))
            }
        }
        items.add(
            GameHalf(
                2,
                gameStats.homeTeam.getSecondHalfScore(),
                gameStats.awayTeam.getSecondHalfScore()
            )
        )
        gameStats.events.filter { it.period == SECOND_HALF }.forEach { event ->
            //Is event from home team
            if (event.teamId == gameStats.homeTeam.id) {
                items.add(HomeEvent(event))
            } else {
                items.add(AwayEvent(event))
            }
        }
        items.add(InfoHeader())
        items.add(GameInfo(R.string.referee, gameStats.getReferee().name))
        items.add(GameInfo(R.string.stadium, gameStats.getStadium()))
        gameStats.attendance?.let { items.add(GameInfo(R.string.attendance, it.formatNumber())) }
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_GAME_HALF -> {
                GameHalfViewHolder(ItemGameHalfBinding.inflate(layoutInflater, parent, false))
            }
            VIEW_TYPE_HOME_EVENT -> {
                HomeEventViewHolder(ItemHomeEventBinding.inflate(layoutInflater, parent, false))
            }
            VIEW_TYPE_AWAY_EVENT -> {
                AwayEventViewHolder(ItemAwayEventBinding.inflate(layoutInflater, parent, false))
            }
            VIEW_TYPE_INFO_HEADER -> {
                InfoHeaderViewHolder(ItemInfoHeaderBinding.inflate(layoutInflater, parent, false))
            }
            VIEW_TYPE_INFO -> {
                InfoViewHolder(ItemGameInfoBinding.inflate(layoutInflater, parent, false))
            }
            else -> throw IllegalStateException("No view holder defined")
        }
    }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        when (holder) {
            is GameHalfViewHolder -> holder.bind(items[position] as GameHalf)
            is HomeEventViewHolder -> holder.bind(items[position] as HomeEvent)
            is AwayEventViewHolder -> holder.bind(items[position] as AwayEvent)
            is InfoViewHolder -> holder.bind(items[position] as GameInfo)
            else -> {}
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].viewType
    }

    open class DetailsViewHolder(itemView: ViewGroup) : RecyclerView.ViewHolder(itemView) {
        protected val context: Context = itemView.context
    }

    class GameHalfViewHolder(binding: ItemGameHalfBinding) : DetailsViewHolder(binding.root) {
        private val halfName = binding.tvHalf
        private val halfResult = binding.tvResult

        fun bind(gameHalf: GameHalf) {
            halfName.text = context.getString(R.string.half_name, gameHalf.half)
            halfResult.text =
                context.getString(R.string.result_string, gameHalf.homeScore, gameHalf.awayScore)
        }
    }

    class HomeEventViewHolder(binding: ItemHomeEventBinding) : DetailsViewHolder(binding.root) {
        private val timeText = binding.tvTime
        private val eventIcon = binding.ivEvent
        private val eventText = binding.tvEvent

        fun bind(homeEvent: HomeEvent) {
            timeText.text = homeEvent.event.time
            eventIcon.setImageResource(homeEvent.event.generateEventIcon())
            eventText.text = homeEvent.event.generateEventText()
        }
    }

    class AwayEventViewHolder(binding: ItemAwayEventBinding) : DetailsViewHolder(binding.root) {
        private val timeText = binding.tvTime
        private val eventIcon = binding.ivEvent
        private val eventText = binding.tvEvent

        fun bind(awayEvent: AwayEvent) {
            timeText.text = awayEvent.event.time
            eventIcon.setImageResource(awayEvent.event.generateEventIcon())
            eventText.text = awayEvent.event.generateEventText()
        }
    }

    class InfoHeaderViewHolder(binding: ItemInfoHeaderBinding) : DetailsViewHolder(binding.root)
    class InfoViewHolder(binding: ItemGameInfoBinding) : DetailsViewHolder(binding.root) {
        private val infoLabel = binding.tvInfo
        private val infoValue = binding.tvInfoValue

        fun bind(gameInfo: GameInfo) {
            infoLabel.setText(gameInfo.label)
            infoValue.text = gameInfo.value
        }
    }

    open class DetailsModel(val viewType: Int)

    class GameHalf(
        val half: Int,
        val homeScore: Int,
        val awayScore: Int
    ) : DetailsModel(VIEW_TYPE_GAME_HALF)

    class InfoHeader : DetailsModel(VIEW_TYPE_INFO_HEADER)
    class GameInfo(@StringRes val label: Int, val value: String) : DetailsModel(VIEW_TYPE_INFO)
    class HomeEvent(val event: GameEvent) : DetailsModel(VIEW_TYPE_HOME_EVENT)
    class AwayEvent(val event: GameEvent) : DetailsModel(VIEW_TYPE_AWAY_EVENT)
}