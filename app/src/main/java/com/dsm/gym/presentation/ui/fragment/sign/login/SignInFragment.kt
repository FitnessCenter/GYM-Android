package com.dsm.gym.presentation.ui.fragment.sign.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dsm.gym.R
import kotlinx.android.synthetic.main.fragment_login.view.*

class SignInFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("onCreateView","execute")
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        view.login_register_tv.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_firstRegisterFragment)
        }
        view.login_btn.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_homeFragment)
        }
        return view
    }
}