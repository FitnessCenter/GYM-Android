package com.dsm.gym.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.dsm.gym.R
import kotlinx.android.synthetic.main.fragment_change_password.*


class ChangePasswordFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_change_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        change_password_btn.setOnClickListener {
            requireActivity().findNavController(R.id.account_service_container).navigate(R.id.action_changePasswordFragment_to_signInFragment)

        }
    }



}