package com.dsm.gym.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dsm.gym.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {
    private val navigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.home_fragment -> return@OnNavigationItemSelectedListener selectHome()
            R.id.apply_exercise_fragment ->return@OnNavigationItemSelectedListener selectApplyExercise()
            R.id.apply_equipment_fragment -> return@OnNavigationItemSelectedListener selectApplyEquipment()
            R.id.mypage_fragment -> return@OnNavigationItemSelectedListener selectMyPage()
        }
        false
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        main_navigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener)

    }
    private fun replaceFragment(action : Int){
        childFragmentManager.primaryNavigationFragment!!.findNavController().navigate(action)

    }
    private fun selectHome() : Boolean{
        replaceFragment(R.id.action_global_homeFragment)
        return true

    }
    private fun selectApplyExercise(): Boolean{
        replaceFragment(R.id.action_global_applyExerciseFragment)
        return true
    }
    private fun selectApplyEquipment(): Boolean{
        replaceFragment(R.id.action_global_applyEquipmentFragment)
        return true
    }
    private fun selectMyPage(): Boolean{
        replaceFragment(R.id.action_global_myPageFragment)
        return true
    }
}