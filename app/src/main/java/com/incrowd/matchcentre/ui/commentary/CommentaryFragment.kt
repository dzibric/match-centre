package com.incrowd.matchcentre.ui.commentary

import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import com.incrowd.matchcentre.R
import com.incrowd.matchcentre.databinding.FragmentCommentaryBinding
import com.incrowd.matchcentre.ui.base.BaseViewModelFragment
import com.incrowd.matchcentre.utils.MATCH_ID
import com.incrowd.matchcentre.utils.loadImage
import com.incrowd.matchcentre.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CommentaryFragment :
    BaseViewModelFragment<CommentaryViewModel>(R.layout.fragment_commentary) {

    private val binding by viewBinding(FragmentCommentaryBinding::bind)
    override val viewModel: CommentaryViewModel by viewModels()

    override fun onViewVisible() {
        viewModel.getCommentaryData(MATCH_ID)
    }

    override fun setupViewModel(viewModel: CommentaryViewModel, owner: LifecycleOwner) {
        viewModel.commentaryData.observe(owner) { data ->
            binding.apply {
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