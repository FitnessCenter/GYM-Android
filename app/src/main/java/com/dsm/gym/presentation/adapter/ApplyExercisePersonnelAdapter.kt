package com.dsm.gym.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.dsm.gym.BR
import com.dsm.gym.databinding.ItemApplyExercisePersonnelBinding
import com.dsm.gym.presentation.model.AppliedUserModel
import com.dsm.gym.presentation.model.UserInfoModel


class ApplyExercisePersonnelAdapter : RecyclerView.Adapter<ApplyExercisePersonnelAdapter.ViewHolder>() {

    private val items = mutableListOf<UserInfoModel>()


    inner class ViewHolder(val binding : ViewDataBinding) : RecyclerView.ViewHolder(
        binding.root){

        fun bind(item:UserInfoModel){
            binding.setVariable(BR.userItem,item)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(inflater, viewType, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)  {
        holder.bind(getItem(position))
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size


    private fun getItem(position: Int) : UserInfoModel{
        return items[position]
    }
    fun updateData(items: MutableLiveData<List<UserInfoModel>>) {
        this.items.addAll(items.value!!)
        notifyDataSetChanged()
    }
}