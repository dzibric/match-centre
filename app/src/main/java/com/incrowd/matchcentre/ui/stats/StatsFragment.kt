package com.incrowd.matchcentre.ui.stats

import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import com.incrowd.matchcentre.R
import com.incrowd.matchcentre.databinding.FragmentStatsBinding
import com.incrowd.matchcentre.ui.base.BaseViewModelFragment
import com.incrowd.matchcentre.utils.MATCH_ID
import com.incrowd.matchcentre.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatsFragment :
    BaseViewModelFragment<StatsViewModel>(R.layout.fragment_stats) {

    private val binding by viewBinding(FragmentStatsBinding::bind)
    override val viewModel: StatsViewModel by viewModels()

    override fun onViewVisible() {
        viewModel.getStatsData(MATCH_ID)
    }

    override fun setupViewModel(viewModel: StatsViewModel, owner: LifecycleOwner) {
        viewModel.statsData.observe(owner) { data ->
            data
        }

    }
}