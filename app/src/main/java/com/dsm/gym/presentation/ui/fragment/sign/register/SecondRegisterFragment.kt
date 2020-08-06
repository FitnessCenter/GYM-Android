package com.dsm.gym.presentation.ui.fragment.sign.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dsm.gym.R
import kotlinx.android.synthetic.main.fragment_second_register.view.*

class SecondRegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second_register, container, false)
        view.register_btn.setOnClickListener {
            findNavController().navigate(R.id.action_secondRegisterFragment_to_completeRegisterFragment)
        }
        return view
    }
}