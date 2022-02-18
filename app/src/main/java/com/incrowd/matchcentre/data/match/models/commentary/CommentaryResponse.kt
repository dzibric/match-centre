package com.incrowd.matchcentre.data.match.models.commentary

import com.google.gson.annotations.SerializedName

data class CommentaryResponse(@SerializedName("data") val commentaryData: CommentaryData)