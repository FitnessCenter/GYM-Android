package com.dsm.gym.presentation.ui.fragment.equipment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.dsm.gym.R
import com.dsm.gym.presentation.ui.dialog.ApplyEquipmentDetailDialogFragment
import com.dsm.gym.presentation.ui.dialog.LogoutDialogFragment
import com.dsm.gym.presentation.ui.fragment.base.EndPointDataBindingFragment
import kotlinx.android.synthetic.main.fragment_apply_equipment.view.*
import kotlinx.android.synthetic.main.fragment_apply_equipment_detail_dialog.view.*
import kotlinx.android.synthetic.main.fragment_apply_equipment_detail_dialog.view.apply_equipment_detail_btn

class ApplyEquipmentFragment : EndPointDataBindingFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_apply_equipment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.add_equipment_btn.setOnClickListener {
            showDialog()
        }
    }
    private fun showDialog(){
        val dialog = ApplyEquipmentDetailDialogFragment()
        dialog.show(requireActivity().supportFragmentManager, "ApplyEquipmentDetailDialogFragment")
    }
}