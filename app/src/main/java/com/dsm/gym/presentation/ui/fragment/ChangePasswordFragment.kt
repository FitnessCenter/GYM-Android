package com.dsm.gym.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.dsm.gym.R
import com.dsm.gym.databinding.FragmentChangePasswordBinding
import com.dsm.gym.presentation.base.EndPointDataBindingFragment
import com.dsm.gym.presentation.viewmodel.mypage.ChangePasswordViewModel
import kotlinx.android.synthetic.main.fragment_change_password.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class ChangePasswordFragment : EndPointDataBindingFragment<FragmentChangePasswordBinding>() {

    override val layoutId : Int = R.layout.fragment_change_password
    override val viewModel : ChangePasswordViewModel by viewModel()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
    }



    override fun observeEvent() {
        viewModel.passwordChangedEvent.observe(this, Observer {
            requireActivity().findNavController(R.id.account_service_container).navigate(R.id.action_changePasswordFragment_to_signInFragment)
        })
    }


}