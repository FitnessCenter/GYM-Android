package com.dsm.gym.presentation.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.dsm.gym.R
import com.dsm.gym.databinding.FragmentMyPageBinding
import com.dsm.gym.presentation.base.EndPointDataBindingFragment
import com.dsm.gym.presentation.ui.dialog.LogoutDialogFragment
import com.dsm.gym.presentation.viewmodel.mypage.MyPageViewModel
import kotlinx.android.synthetic.main.fragment_my_page.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MyPageFragment : EndPointDataBindingFragment<FragmentMyPageBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_my_page
    override val viewModel : MyPageViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

        my_page_logout_layout.setOnClickListener {
            val dialog = LogoutDialogFragment()
            dialog.show(requireActivity().supportFragmentManager, "LogOutDialogFragment")
        }
        my_page_change_password_layout.setOnClickListener {
            requireActivity().findNavController(R.id.account_service_container).navigate(R.id.action_mainFragment_to_changePasswordFragment)

        }
        my_page_equipment_history_layout.setOnClickListener {
            requireActivity().findNavController(R.id.account_service_container).navigate(R.id.action_mainFragment_to_equipmentHistoryFragment)
        }
    }


    override fun observeEvent() {
    }


}