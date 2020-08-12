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

        when(main_navigation.selectedItemId){
            R.id.apply_exercise_fragment-> replaceFragment(R.id.action_applyExerciseFragment_to_homeFragment)

            R.id.apply_equipment_fragment-> replaceFragment(R.id.action_applyEquipmentFragment_to_homeFragment)

            R.id.mypage_fragment-> replaceFragment(R.id.action_myPageFragment_to_homeFragment)
        }
        return true

    }
    private fun selectApplyExercise(): Boolean{

        when(main_navigation.selectedItemId){
            R.id.home_fragment-> replaceFragment(R.id.action_homeFragment_to_applyExerciseFragment)

            R.id.apply_equipment_fragment-> replaceFragment(R.id.action_applyEquipmentFragment_to_applyExerciseFragment)

            R.id.mypage_fragment-> replaceFragment(R.id.action_myPageFragment_to_applyExerciseFragment)


        }
        return true


    }
    private fun selectApplyEquipment(): Boolean{

        when(main_navigation.selectedItemId){
            R.id.home_fragment-> replaceFragment(R.id.action_homeFragment_to_applyEquipmentFragment)

            R.id.apply_exercise_fragment-> replaceFragment(R.id.action_applyExerciseFragment_to_applyEquipmentFragment)

            R.id.mypage_fragment-> replaceFragment(R.id.action_myPageFragment_to_applyEquipmentFragment)


        }
        return true

    }
    private fun selectMyPage(): Boolean{

        when(main_navigation.selectedItemId){
            R.id.home_fragment-> replaceFragment(R.id.action_homeFragment_to_myPageFragment)

            R.id.apply_exercise_fragment-> replaceFragment(R.id.action_applyExerciseFragment_to_myPageFragment)

            R.id.apply_equipment_fragment-> replaceFragment(R.id.action_applyEquipmentFragment_to_myPageFragment)


        }
        return true

    }




}