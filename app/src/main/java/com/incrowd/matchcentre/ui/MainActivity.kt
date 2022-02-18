package com.incrowd.matchcentre.ui

import androidx.navigation.findNavController
import com.incrowd.matchcentre.R
import com.incrowd.matchcentre.databinding.ActivityMainBinding
import com.incrowd.matchcentre.ui.base.BaseActivity
import com.incrowd.matchcentre.ui.commentary.CommentaryFragmentDirections
import com.incrowd.matchcentre.ui.stats.StatsFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val binding by viewBinding(ActivityMainBinding::inflate)

    override fun setupViews(viewBinding: ActivityMainBinding) {
        binding.radioGroup.apply {
            setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.btn_commentary -> {
                        findNavController(R.id.fragment_container_view).navigate(
                            StatsFragmentDirections.actionStatsToCommentary()
                        )
                    }
                    R.id.btn_stats -> {
                        findNavController(R.id.fragment_container_view).navigate(
                            CommentaryFragmentDirections.actionCommentaryToStats()
                        )
                    }
                }
            }
        }
    }
}