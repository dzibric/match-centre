package com.incrowd.matchcentre.data.match.models.stats

import com.google.gson.annotations.SerializedName

data class StatsResponse(@SerializedName("data") val statsData: StatsData)