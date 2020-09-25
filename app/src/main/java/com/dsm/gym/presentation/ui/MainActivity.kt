package com.dsm.gym.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dsm.gym.R
import com.dsm.gym.presentation.viewmodel.applyexercise.ApplyExerciseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private val applyExerciseViewModel by viewModel<ApplyExerciseViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


}