package com.dsm.gym.presentation.ui.fragment.signin

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.Navigation.findNavController
import com.dsm.gym.R
import com.dsm.gym.databinding.FragmentSigninBinding
import com.dsm.gym.presentation.base.EndPointDataBindingFragment
import com.dsm.gym.presentation.viewmodel.signin.SignInViewModel
import kotlinx.android.synthetic.main.fragment_signin.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignInFragment : EndPointDataBindingFragment<FragmentSigninBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_signin

    override val viewModel: SignInViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
    }

    override fun observeEvent() {
        viewModel.startSignUpEvent.observe(this, Observer {
            findNavController(requireView()).navigate(R.id.action_signInFragment_to_firstRegisterFragment)
        })
        viewModel.idErrorEvent.observe(this, Observer { login_id_edit_layout.error = it })

        viewModel.passwordErrorEvent.observe(this, Observer { login_pw_edit_layout.error = it })

        viewModel.startMainEvent.observe(this, Observer {
            findNavController(requireView()).navigate(R.id.action_signInFragment_to_mainFragment)
        })
    }

}