package com.dsm.gym.presentation.ui.fragment.main

import android.os.Bundle
import android.view.View
import com.dsm.gym.R
import com.dsm.gym.databinding.FragmentHomeBinding
import com.dsm.gym.presentation.base.EndPointDataBindingFragment
import com.dsm.gym.presentation.viewmodel.home.HomePageViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : EndPointDataBindingFragment<FragmentHomeBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_home

    override val viewModel: HomePageViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homeVm = viewModel
    }


    override fun observeEvent() {

    }
}