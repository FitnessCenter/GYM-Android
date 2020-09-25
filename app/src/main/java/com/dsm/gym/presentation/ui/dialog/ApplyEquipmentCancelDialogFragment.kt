package com.dsm.gym.presentation.ui.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.dsm.gym.R
import com.dsm.gym.databinding.FragmentApplyEquipmentCancelDialogBinding
import com.dsm.gym.presentation.base.DataBindingDialogFragment
import com.dsm.gym.presentation.viewmodel.mypage.EquipmentHistoryViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class ApplyEquipmentCancelDialogFragment : DataBindingDialogFragment<FragmentApplyEquipmentCancelDialogBinding>() {

    override val layoutId: Int = R.layout.fragment_apply_equipment_cancel_dialog

    override val viewModel by sharedViewModel<EquipmentHistoryViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

    }

    override fun observeEvent() {
        viewModel.dismissEvent.observe(viewLifecycleOwner, Observer {
            dismiss()
        })
    }


}