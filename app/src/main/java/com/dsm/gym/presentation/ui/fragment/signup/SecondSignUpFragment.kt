package com.dsm.gym.presentation.ui.fragment.signup

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.dsm.gym.R
import com.dsm.gym.databinding.FragmentSecondSignupBinding
import com.dsm.gym.presentation.base.DataBindingFragment
import com.dsm.gym.presentation.base.EndPointDataBindingFragment
import com.dsm.gym.presentation.viewmodel.signup.SignUpViewModel
import kotlinx.android.synthetic.main.fragment_second_signup.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SecondSignUpFragment : DataBindingFragment<FragmentSecondSignupBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_second_signup

    override val viewModel: SignUpViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.secondVm = viewModel

        getArgSignUpData()
    }


    override fun observeEvent() {
        viewModel.startCompleteSignUpEvent.observe(this, Observer{
            Navigation.findNavController(requireView()).navigate(R.id.action_secondRegisterFragment_to_completeRegisterFragment)
        })
        viewModel.passwordErrorEvent.observe(this, Observer { register_pw_edit_layout.error = it })

        viewModel.passwordCheckErrorEvent.observe(this, Observer { register_pw_check_edit_layout.error = it })
    }

    private fun getArgSignUpData() {
        viewModel.studentNumberText.value = arguments?.getString("studentNumber")
        viewModel.studentNameText.value = arguments?.getString("studentName")
        viewModel.sex.value = arguments?.getBoolean("sex")
    }
}