package com.dsm.gym.presentation.ui.fragment.equipment

import ApplyEquipmentDetailDialogFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dsm.gym.R
import com.dsm.gym.presentation.ui.fragment.base.EndPointDataBindingFragment
import kotlinx.android.synthetic.main.fragment_apply_equipment.view.*

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