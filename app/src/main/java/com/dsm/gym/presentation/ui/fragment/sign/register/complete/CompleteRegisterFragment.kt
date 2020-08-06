package com.dsm.gym.presentation.ui.fragment.sign.register.complete

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dsm.gym.R
import kotlinx.android.synthetic.main.fragment_complete_register.view.*

class CompleteRegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_complete_register, container, false)
        view.register_complete_btn.setOnClickListener {
            findNavController().navigate(R.id.action_completeRegisterFragment_to_signInFragment)
        }
        return view
    }
}