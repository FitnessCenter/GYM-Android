package com.dsm.gym.presentation.base

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import splitties.toast.toast

abstract class DataBindingDialogFragment<T : ViewDataBinding> : DialogFragment() {
    lateinit var rootView: View
    lateinit var binding: T

    abstract val layoutId: Int
    abstract val viewModel: BaseViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = this
        rootView = binding.root
        return rootView
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        observeEvent()
        viewModel.createToastEvent.observe(viewLifecycleOwner, Observer { toast(it) })
    }
    abstract fun observeEvent()

}