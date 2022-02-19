package com.incrowd.matchcentre.utils

import java.text.NumberFormat
import java.util.*

fun Int.formatNumber(): String {
    return NumberFormat.getInstance(Locale.FRANCE).format(this)
}