package com.dsm.gym.presentation.ui.dialog


import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.findNavController
import com.dsm.gym.R
import kotlinx.android.synthetic.main.fragment_logout_dialog.view.*


class LogoutDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_logout_dialog, container,false)
        dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.logout_confirm_tv.setOnClickListener {
            requireActivity().findNavController(R.id.account_service_container).navigate(R.id.action_mainFragment_to_signInFragment)
            dialog!!.dismiss()
        }
        view.logout_cancel_tv.setOnClickListener {
            dialog!!.dismiss()
        }
    }






}