package com.incrowd.matchcentre.ui.main.stats

import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.incrowd.matchcentre.R
import com.incrowd.matchcentre.databinding.FragmentStatsBinding
import com.incrowd.matchcentre.ui.base.BaseViewModelFragment
import com.incrowd.matchcentre.ui.main.MainViewModel
import com.incrowd.matchcentre.utils.MATCH_ID
import com.incrowd.matchcentre.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatsFragment :
    BaseViewModelFragment<MainViewModel>(R.layout.fragment_stats) {

    private val binding by viewBinding(FragmentStatsBinding::bind)
    override val viewModel: MainViewModel by activityViewModels()

    override fun onViewVisible() {
        viewModel.getStatsData(MATCH_ID)
    }

    override fun setupViewModel(viewModel: MainViewModel, owner: LifecycleOwner) {
        viewModel.statsData.observe(owner) { data ->
            binding.recyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = StatsAdapter(data)
            }
        }
    }
}