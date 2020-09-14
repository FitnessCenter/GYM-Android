package com.dsm.gym.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.dsm.gym.R
import com.dsm.gym.presentation.ui.dialog.LogoutDialogFragment
import kotlinx.android.synthetic.main.fragment_my_page.view.*


class MyPageFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_page, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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




}