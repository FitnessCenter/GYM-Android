package com.dsm.gym.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.dsm.gym.BR
import com.dsm.gym.databinding.ItemApplyExercisePersonnelBinding
import com.dsm.gym.presentation.model.UserInfoModel


class ApplyExercisePersonnelAdapter : RecyclerView.Adapter<ApplyExercisePersonnelAdapter.ViewHolder<UserInfoModel>>() {

    private var items = ArrayList<UserInfoModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<UserInfoModel> {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = ItemApplyExercisePersonnelBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder<UserInfoModel>, position: Int)  {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int = items.size

    private fun getItem(position: Int) : UserInfoModel{
        return items[position]
    }
    fun setItem(items: MutableLiveData<ArrayList<UserInfoModel>>) {
        this.items = items.value!!
        notifyDataSetChanged()
    }

    inner class ViewHolder<T>(val binding : ViewDataBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item : T){
            binding.setVariable(BR.userItem,item)
        }

    }
}