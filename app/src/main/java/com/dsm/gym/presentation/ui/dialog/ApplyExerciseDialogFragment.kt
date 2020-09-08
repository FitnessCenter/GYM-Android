package com.dsm.gym.presentation.ui.dialog


import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.dsm.gym.R
import com.dsm.gym.databinding.FragmentApplyExerciseDialogBinding
import com.dsm.gym.presentation.base.BaseViewModel
import com.dsm.gym.presentation.base.DataBindingDialogFragment
import com.dsm.gym.presentation.viewmodel.applyexercise.ApplyExerciseViewModel
import kotlinx.android.synthetic.main.fragment_apply_exercise_dialog.view.*
import kotlinx.android.synthetic.main.fragment_show_personnel_dialog.view.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import splitties.views.onClick


class ApplyExerciseDialogFragment : DataBindingDialogFragment<FragmentApplyExerciseDialogBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_apply_exercise_dialog
    override val viewModel : ApplyExerciseViewModel by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

        view.apply_exercise_close_img.onClick { dismiss()}
    }

    override fun observeEvent() {

    }


}