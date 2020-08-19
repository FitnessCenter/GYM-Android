package com.dsm.gym.presentation.ui.fragment.signup

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.dsm.gym.R
import com.dsm.gym.databinding.FragmentFirstSignupBinding
import com.dsm.gym.presentation.base.EndPointDataBindingFragment
import com.dsm.gym.presentation.viewmodel.signup.SignUpViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FirstSignUpFragment : EndPointDataBindingFragment<FragmentFirstSignupBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_first_signup

    override val viewModel: SignUpViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.firstVm = viewModel
    }

    override fun observeEvent() {
        viewModel.startSecondSignUpEvent.observe(this, Observer {
            val bundle = Bundle()
            bundle.putString("studentNumber", viewModel.studentNumberText.value)
            bundle.putString("studentName", viewModel.studentNameText.value)

            Navigation.findNavController(requireView()).navigate(R.id.action_firstRegisterFragment_to_secondRegisterFragment,bundle)
        })
    }
}