package com.incrowd.matchcentre.ui.main

import androidx.activity.viewModels
import androidx.lifecycle.LifecycleOwner
import com.google.android.material.tabs.TabLayoutMediator
import com.incrowd.matchcentre.R
import com.incrowd.matchcentre.databinding.ActivityMainBinding
import com.incrowd.matchcentre.ui.base.BaseViewModelActivity
import com.incrowd.matchcentre.utils.MATCH_ID
import com.incrowd.matchcentre.utils.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseViewModelActivity<MainViewModel, ActivityMainBinding>() {

    override val binding by viewBinding(ActivityMainBinding::inflate)
    override val viewModel: MainViewModel by viewModels()

    override fun setupViews(viewBinding: ActivityMainBinding) {
        val mainTabLayoutAdapter = MainTabLayoutAdapter(this)
        binding.viewPager.adapter = mainTabLayoutAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = getString(mainTabLayoutAdapter.getTitle(position))
        }.attach()
        viewModel.getCommentaryData(MATCH_ID)
    }

    override fun setupViewModel(viewModel: MainViewModel, owner: LifecycleOwner) {
        viewModel.commentaryData.observe(owner) { data ->
            binding.headerLayout.apply {
                homeTeamLogo.loadImage(data.homeTeamImageUrl)
                awayTeamLogo.loadImage(data.awayTeamImageUrl)
                homeTeamName.text = data.homeTeamName
                awayTeamName.text = data.awayTeamName
                result.text = getString(R.string.result_string, data.homeScore, data.awayScore)
                leagueName.text = data.competition
            }
        }
    }
}