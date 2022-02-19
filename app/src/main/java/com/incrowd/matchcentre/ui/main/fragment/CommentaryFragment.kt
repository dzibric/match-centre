package com.incrowd.matchcentre.ui.main.fragment

import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.incrowd.matchcentre.R
import com.incrowd.matchcentre.databinding.FragmentCommentaryBinding
import com.incrowd.matchcentre.ui.base.BaseViewModelFragment
import com.incrowd.matchcentre.ui.main.MainViewModel
import com.incrowd.matchcentre.utils.MATCH_ID
import com.incrowd.matchcentre.utils.loadImage
import com.incrowd.matchcentre.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CommentaryFragment :
    BaseViewModelFragment<MainViewModel>(R.layout.fragment_commentary) {

    private val binding by viewBinding(FragmentCommentaryBinding::bind)
    override val viewModel: MainViewModel by activityViewModels()

    override fun onViewVisible() {
        viewModel.getCommentaryData(MATCH_ID)
    }

    override fun setupViewModel(viewModel: MainViewModel, owner: LifecycleOwner) {

    }
}