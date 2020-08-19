package com.dsm.gym.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.dsm.gym.R
import com.dsm.gym.presentation.ui.dialog.ApplyExerciseDialogFragment
import com.dsm.gym.presentation.ui.dialog.ShowPersonnelDialogFragment
import com.dsm.gym.presentation.ui.fragment.base.EndPointDataBindingFragment
import kotlinx.android.synthetic.main.fragment_apply_exercise.view.*


class ApplyExerciseFragment : EndPointDataBindingFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_apply_exercise, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.apply_exercise_nine_thirty_to_ten_apply_btn.setOnClickListener {
            showDialog(ApplyExerciseDialogFragment())
        }
        view.apply_exercise_ten_to_ten_thirty_apply_btn.setOnClickListener {
            showDialog(ApplyExerciseDialogFragment())
        }
        view.apply_exercise_ten_thirty_to_eleven_apply_btn.setOnClickListener {
            showDialog(ApplyExerciseDialogFragment())
        }
        view.apply_exercise_show_personnel_nine_thirty_to_ten_btn.setOnClickListener {
            showDialog(ShowPersonnelDialogFragment())
        }
        view.apply_exercise_show_personnel_ten_to_ten_thirty_personnel_btn.setOnClickListener {
            showDialog(ShowPersonnelDialogFragment())
        }
        view.apply_exercise_show_personnel_ten_thirty_to_eleven_personnel_btn.setOnClickListener {
            showDialog(ShowPersonnelDialogFragment())
        }

    }
    private fun showDialog(dialogFragment: DialogFragment){
        dialogFragment.show(requireActivity().supportFragmentManager, dialogFragment.toString())
    }


}