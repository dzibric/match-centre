package com.incrowd.matchcentre.ui.base

import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseViewModelActivity<VM : ViewModel, VB : ViewBinding> : BaseActivity<VB>() {

    abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewModel(viewModel, this)
    }

    abstract fun setupViewModel(viewModel: VM, owner: LifecycleOwner)
}