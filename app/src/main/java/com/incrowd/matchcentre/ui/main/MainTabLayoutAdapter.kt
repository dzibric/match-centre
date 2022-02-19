package com.incrowd.matchcentre.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.incrowd.matchcentre.R
import com.incrowd.matchcentre.ui.main.fragment.CommentaryFragment
import com.incrowd.matchcentre.ui.main.details.DetailsFragment
import com.incrowd.matchcentre.ui.main.stats.StatsFragment

class MainTabLayoutAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    private val fragments = listOf(
        Pair(DetailsFragment(), R.string.details),
        Pair(StatsFragment(), R.string.match_stats),
        Pair(CommentaryFragment(), R.string.commentary)
    )

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return fragments[position].first
    }

    fun getTitle(position: Int): Int {
        return fragments[position].second
    }
}