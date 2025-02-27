package com.dsm.gym.presentation.ui.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.dsm.gym.R
import com.dsm.gym.databinding.FragmentApplyEquipmentDetailDialogBinding
import com.dsm.gym.presentation.base.DataBindingDialogFragment
import com.dsm.gym.presentation.viewmodel.equipment.EquipmentDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ApplyEquipmentDetailDialogFragment : DataBindingDialogFragment<FragmentApplyEquipmentDetailDialogBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_apply_equipment_detail_dialog

    override val viewModel: EquipmentDetailViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

    }

    override fun observeEvent() {
        viewModel.goMainEquipmentPage.observe(this, Observer { dismiss() })
        viewModel.closeDialog.observe(this, Observer { dismiss() })  
    }

}