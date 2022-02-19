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

class DetailsAdapter(gameStats: StatsData) :
    RecyclerView.Adapter<DetailsAdapter.DetailsViewHolder>() {

    companion object {
        private const val VIEW_TYPE_GAME_HALF = 1
        private const val VIEW_TYPE_HOME_EVENT = 2
        private const val VIEW_TYPE_AWAY_EVENT = 3
        private const val VIEW_TYPE_INFO_HEADER = 4
        private const val VIEW_TYPE_INFO = 5
    }

    private var items = DetailsHelper.generateItems(gameStats)

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
            is GameHalfViewHolder -> holder.bind(items[position] as GameHalfModel)
            is HomeEventViewHolder -> holder.bind(items[position] as HomeEventModel)
            is AwayEventViewHolder -> holder.bind(items[position] as AwayEventModel)
            is InfoViewHolder -> holder.bind(items[position] as GameInfoModel)
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

        fun bind(gameHalfModel: GameHalfModel) {
            halfName.text = context.getString(R.string.half_name, gameHalfModel.half)
            halfResult.text =
                context.getString(
                    R.string.result_string,
                    gameHalfModel.homeScore,
                    gameHalfModel.awayScore
                )
        }
    }

    class HomeEventViewHolder(binding: ItemHomeEventBinding) : DetailsViewHolder(binding.root) {
        private val timeText = binding.tvTime
        private val eventIcon = binding.ivEvent
        private val eventText = binding.tvEvent

        fun bind(homeEventModel: HomeEventModel) {
            timeText.text = homeEventModel.event.time
            eventIcon.setImageResource(homeEventModel.event.generateEventIcon())
            eventText.text = homeEventModel.event.generateEventText()
        }
    }

    class AwayEventViewHolder(binding: ItemAwayEventBinding) : DetailsViewHolder(binding.root) {
        private val timeText = binding.tvTime
        private val eventIcon = binding.ivEvent
        private val eventText = binding.tvEvent

        fun bind(awayEventModel: AwayEventModel) {
            timeText.text = awayEventModel.event.time
            eventIcon.setImageResource(awayEventModel.event.generateEventIcon())
            eventText.text = awayEventModel.event.generateEventText()
        }
    }

    class InfoHeaderViewHolder(binding: ItemInfoHeaderBinding) : DetailsViewHolder(binding.root)

    class InfoViewHolder(binding: ItemGameInfoBinding) : DetailsViewHolder(binding.root) {
        private val infoLabel = binding.tvInfo
        private val infoValue = binding.tvInfoValue

        fun bind(gameInfoModel: GameInfoModel) {
            infoLabel.setText(gameInfoModel.label)
            infoValue.text = gameInfoModel.value
        }
    }

    open class DetailsModel(val viewType: Int)

    class GameHalfModel(
        val half: Int,
        val homeScore: Int,
        val awayScore: Int
    ) : DetailsModel(VIEW_TYPE_GAME_HALF)

    class InfoHeaderModel : DetailsModel(VIEW_TYPE_INFO_HEADER)
    class GameInfoModel(@StringRes val label: Int, val value: String) : DetailsModel(VIEW_TYPE_INFO)
    class HomeEventModel(val event: GameEvent) : DetailsModel(VIEW_TYPE_HOME_EVENT)
    class AwayEventModel(val event: GameEvent) : DetailsModel(VIEW_TYPE_AWAY_EVENT)
}