package com.dsm.gym.presentation.ui.dialog



import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.dsm.gym.R
import com.dsm.gym.databinding.FragmentLogoutDialogBinding
import com.dsm.gym.presentation.base.DataBindingDialogFragment
import com.dsm.gym.presentation.viewmodel.mypage.MyPageViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class LogoutDialogFragment : DataBindingDialogFragment<FragmentLogoutDialogBinding>() {

    override val layoutId: Int = R.layout.fragment_logout_dialog

    override val viewModel by sharedViewModel<MyPageViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
    }

    override fun observeEvent() {
        viewModel.logoutConfirmEvent.observe(viewLifecycleOwner, Observer {
            requireActivity().findNavController(R.id.account_service_container).navigate(R.id.action_mainFragment_to_signInFragment)
            dismiss()
        })
        viewModel.logoutCancelEvent.observe(viewLifecycleOwner, Observer {
            dismiss()
        })
    }




}