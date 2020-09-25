package com.dsm.gym.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import splitties.toast.toast

abstract class DataBindingFragment<T : ViewDataBinding> : Fragment() {

    private lateinit var rootView: View
    lateinit var binding: T

    abstract val layoutId: Int
    abstract val viewModel: BaseViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        rootView = binding.root
        binding.lifecycleOwner = this

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeEvent()

        viewModel.createToastEvent.observe(this, Observer { toast(it) })
    }

    abstract fun observeEvent()
}