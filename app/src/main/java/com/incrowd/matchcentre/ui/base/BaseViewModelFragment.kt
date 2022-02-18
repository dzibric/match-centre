package com.incrowd.matchcentre.ui.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel

abstract class BaseViewModelFragment<VM: ViewModel>(layoutId: Int): Fragment(layoutId) {

    abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel(viewModel, viewLifecycleOwner)
        onViewVisible()
    }

    abstract fun onViewVisible()
    abstract fun setupViewModel(viewModel: VM, owner: LifecycleOwner)
}