package com.dsm.gym.presentation.ui.fragment.equipment

import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.dsm.gym.R
import com.dsm.gym.databinding.FragmentApplyEquipmentBinding
import com.dsm.gym.presentation.adapter.EquipmentListAdapter
import com.dsm.gym.presentation.base.EndPointDataBindingFragment
import com.dsm.gym.presentation.ui.dialog.ApplyEquipmentDetailDialogFragment
import com.dsm.gym.presentation.viewmodel.equipment.EquipmentListViewModel
import kotlinx.android.synthetic.main.fragment_apply_equipment.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ApplyEquipmentFragment : EndPointDataBindingFragment<FragmentApplyEquipmentBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_apply_equipment

    override val viewModel: EquipmentListViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

        binding.equipmentList.layoutManager = LinearLayoutManager(context)
        binding.equipmentList.adapter = EquipmentListAdapter(viewModel)

        view.add_equipment_btn.setOnClickListener {
            showDialog()
        }
    }
    private fun showDialog(){
        val dialog = ApplyEquipmentDetailDialogFragment()
        dialog.show(requireActivity().supportFragmentManager, "ApplyEquipmentDetailDialogFragment")
    }

    override fun observeEvent() {

    }
}