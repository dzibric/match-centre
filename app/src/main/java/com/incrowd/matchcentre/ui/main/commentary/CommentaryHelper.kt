package com.incrowd.matchcentre.ui.main.commentary

import com.incrowd.matchcentre.data.match.models.commentary.CommentaryData
import com.incrowd.matchcentre.ui.main.commentary.CommentaryAdapter.CommentaryModel

object CommentaryHelper {
    fun generateCommentaryModels(commentaryData: CommentaryData): List<CommentaryModel> {
        return commentaryData.commentaryEntries.map { CommentaryModel(it) }
    }
}