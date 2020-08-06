package com.dsm.gym.presentation.ui.fragment.sign.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dsm.gym.R
import kotlinx.android.synthetic.main.fragment_first_register.view.*

class FirstRegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first_register, container, false)
        view.register_first_next_btn.setOnClickListener {
            findNavController().navigate(R.id.action_firstRegisterFragment_to_secondRegisterFragment)
        }

        return view
    }
    fun observe(){
        findNavController().navigate(R.id.action_firstRegisterFragment_to_secondRegisterFragment)
    }
}