package com.incrowd.matchcentre.ui.main.commentary

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.incrowd.matchcentre.R
import com.incrowd.matchcentre.data.match.models.commentary.Commentary
import com.incrowd.matchcentre.data.match.models.commentary.CommentaryData
import com.incrowd.matchcentre.databinding.ItemCommentaryBinding
import com.incrowd.matchcentre.utils.*

class CommentaryAdapter(commentaryData: CommentaryData) :
    RecyclerView.Adapter<CommentaryAdapter.CommentaryViewHolder>() {

    private val items = CommentaryHelper.generateCommentaryModels(commentaryData)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentaryViewHolder {
        return CommentaryViewHolder(
            ItemCommentaryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CommentaryViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size


    class CommentaryViewHolder(binding: ItemCommentaryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val timeText = binding.tvTime
        private val commentaryIcon = binding.ivCommentary
        private val commentaryText = binding.tvCommentary
        private val barrierSpace = binding.barrierSpace

        fun bind(commentaryModel: CommentaryModel) {
            val commentary = commentaryModel.commentary
            timeText.text = commentary.time
            commentary.getCommentaryIcon()?.let { commentaryIcon.setImageResource(it) }
            commentaryText.text = commentary.comment
            setTextStyle(commentary.type)
            timeText.isVisible = commentary.time != null
            commentaryIcon.isVisible = commentary.getCommentaryIcon() != null
            barrierSpace.isVisible = timeText.isVisible || commentaryIcon.isVisible
        }

        private fun setTextStyle(type: String) {
            commentaryText.apply {
                when (type) {
                    GOAL.lowercase() -> {
                        typeface = Typeface.DEFAULT_BOLD
                        setTextColor(context.getColor(R.color.yellow))
                    }
                    START, END_1, END_14, END_2, START_DELAY-> {
                        typeface = Typeface.DEFAULT_BOLD
                        setTextColor(context.getColor(R.color.white))
                    }
                    else -> {
                        typeface = Typeface.DEFAULT
                        setTextColor(context.getColor(R.color.white))
                    }
                }
            }
        }
    }

    class CommentaryModel(val commentary: Commentary)
}