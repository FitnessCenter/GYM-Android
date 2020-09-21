package com.dsm.gym.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.dsm.gym.R
import com.dsm.gym.databinding.FragmentMyPageBinding
import com.dsm.gym.presentation.base.BaseViewModel
import com.dsm.gym.presentation.base.EndPointDataBindingFragment
import com.dsm.gym.presentation.ui.dialog.LogoutDialogFragment
import com.dsm.gym.presentation.viewmodel.mypage.MyPageViewModel
import kotlinx.android.synthetic.main.fragment_my_page.view.*
import org.koin.android.ext.android.inject


class MyPageFragment : EndPointDataBindingFragment<FragmentMyPageBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_my_page
    override val viewModel : MyPageViewModel by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
        view.my_page_logout_layout.setOnClickListener {
            val dialog = LogoutDialogFragment()
            dialog.show(requireActivity().supportFragmentManager, "LogOutDialogFragment")
        }
        view.my_page_change_password_layout.setOnClickListener {
            requireActivity().findNavController(R.id.account_service_container).navigate(R.id.action_mainFragment_to_changePasswordFragment)

        }
        view.my_page_equipment_history_layout.setOnClickListener {
            requireActivity().findNavController(R.id.account_service_container).navigate(R.id.action_mainFragment_to_equipmentHistoryFragment)
        }
    }


    override fun observeEvent() {
    }


}