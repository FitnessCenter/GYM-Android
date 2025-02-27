package com.dsm.gym.presentation.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.fragment.app.Fragment
import com.dsm.gym.R
import com.dsm.gym.databinding.FragmentApplyExerciseBinding
import com.dsm.gym.presentation.base.EndPointDataBindingFragment
import com.dsm.gym.presentation.ui.dialog.ApplyExerciseDialogFragment
import com.dsm.gym.presentation.ui.dialog.ShowPersonnelDialogFragment
import com.dsm.gym.presentation.viewmodel.applyexercise.ApplyExerciseViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class ApplyExerciseFragment : EndPointDataBindingFragment<FragmentApplyExerciseBinding>() {

    override val layoutId: Int = R.layout.fragment_apply_exercise
    override val viewModel by sharedViewModel<ApplyExerciseViewModel>()
   
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
    }
  
    override fun observeEvent() {
        viewModel.applyExerciseEvent.observe(viewLifecycleOwner, Observer {
            showDialog(ApplyExerciseDialogFragment())
        })
        viewModel.appliedExercisePersonnelEvent.observe(viewLifecycleOwner, Observer {
            showDialog(ShowPersonnelDialogFragment())
        })
    }
    private fun showDialog(dialogFragment: DialogFragment){
        dialogFragment.show(requireActivity().supportFragmentManager, dialogFragment.toString())
    }


}