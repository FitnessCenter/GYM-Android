package com.dsm.gym.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.dsm.gym.R
import com.dsm.gym.databinding.FragmentEquipmentHistoryBinding
import com.dsm.gym.presentation.adapter.MyEquipmentAdapter
import com.dsm.gym.presentation.base.DataBindingFragment
import com.dsm.gym.presentation.ui.dialog.ApplyEquipmentCancelDialogFragment
import com.dsm.gym.presentation.viewmodel.mypage.EquipmentHistoryViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class EquipmentHistoryFragment : DataBindingFragment<FragmentEquipmentHistoryBinding>() {

    override val layoutId: Int = R.layout.fragment_equipment_history
    override val viewModel by sharedViewModel<EquipmentHistoryViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

        binding.equipmentHistoryRv.layoutManager = LinearLayoutManager(context)
        binding.equipmentHistoryRv.adapter = MyEquipmentAdapter(viewModel)
    }


    override fun observeEvent() {
        viewModel.cancelEquipmentEvent.observe(viewLifecycleOwner, Observer {
            ApplyEquipmentCancelDialogFragment().show(requireActivity().supportFragmentManager,"equipmentCancelDialog")
        })
    }

}