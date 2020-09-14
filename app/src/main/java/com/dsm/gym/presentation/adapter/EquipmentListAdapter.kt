package com.dsm.gym.presentation.adapter

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.dsm.gym.BR
import com.dsm.gym.databinding.ItemApplyEquipmentBinding
import com.dsm.gym.presentation.model.EquipmentListModel
import com.dsm.gym.presentation.viewmodel.equipment.EquipmentListViewModel
import splitties.systemservices.clipboardManager
import splitties.toast.toast


class EquipmentListAdapter(private val viewModel: EquipmentListViewModel): RecyclerView.Adapter<EquipmentListAdapter.EquipmentListViewHolder>(){

    private var equipmentItems = ArrayList<EquipmentListModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EquipmentListViewHolder {
        val binding
                = ItemApplyEquipmentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        binding.vm = viewModel
        return EquipmentListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EquipmentListViewHolder, position: Int) {
        holder.bind(equipmentItems[position])

        holder.binding.equipmentLinkCopyTv.setOnClickListener {
            val clipData = ClipData.newPlainText("purchaseLink",equipmentItems[position].purchaseLink)
            clipboardManager.setPrimaryClip(clipData)

            toast("클립보드에 복사되었습니다.")
        }
    }

    override fun getItemCount(): Int = equipmentItems.size

    fun setItem(equipmentItems: MutableLiveData<ArrayList<EquipmentListModel>>) {
        this.equipmentItems = equipmentItems.value!!
        notifyDataSetChanged()
    }

    inner class EquipmentListViewHolder(val binding: ItemApplyEquipmentBinding): RecyclerView.ViewHolder(
        binding.root.rootView
    ) {

        fun bind(equipment: EquipmentListModel) {
            binding.setVariable(BR.equipmentItem, equipment)
        }

    }
}