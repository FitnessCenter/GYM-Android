package com.dsm.gym.presentation.ui.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.dsm.gym.R
import com.dsm.gym.databinding.FragmentApplyExerciseDialogBinding
import com.dsm.gym.databinding.FragmentShowPersonnelDialogBinding
import com.dsm.gym.presentation.adapter.ApplyExercisePersonnelAdapter
import com.dsm.gym.presentation.base.BaseViewModel
import com.dsm.gym.presentation.base.DataBindingDialogFragment
import com.dsm.gym.presentation.viewmodel.applyexercise.ApplyExerciseViewModel
import kotlinx.android.synthetic.main.fragment_show_personnel_dialog.view.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class ShowPersonnelDialogFragment : DataBindingDialogFragment<FragmentShowPersonnelDialogBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_show_personnel_dialog
    override val viewModel by sharedViewModel<ApplyExerciseViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
        binding.applyExercisePersonnelRv.layoutManager = GridLayoutManager(context,2)
        binding.applyExercisePersonnelRv.adapter = ApplyExercisePersonnelAdapter()
    }

    override fun observeEvent() {
        viewModel.dismissDialogEvent.observe(viewLifecycleOwner, Observer {
            dismiss()
        })
    }

}