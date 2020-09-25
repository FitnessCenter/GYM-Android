package com.dsm.gym.presentation.ui.fragment.signup.complete

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.dsm.gym.R
import com.dsm.gym.databinding.FragmentCompleteSignupBinding
import com.dsm.gym.presentation.base.DataBindingFragment
import com.dsm.gym.presentation.base.EndPointDataBindingFragment
import com.dsm.gym.presentation.viewmodel.signup.SignUpViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CompleteSignUpFragment : DataBindingFragment<FragmentCompleteSignupBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_complete_signup

    override val viewModel: SignUpViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.completeVm = viewModel
    }

    override fun observeEvent() {
        viewModel.startSignInEvent.observe(this, Observer {
            Navigation.findNavController(requireView()).navigate(R.id.action_completeRegisterFragment_to_signInFragment)
        })
    }
}