package com.example.bmiandbmrapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.bmiandbmrapp.R
import com.example.bmiandbmrapp.data.PersonData
import com.example.bmiandbmrapp.databinding.FragmentResultsBinding
import com.example.bmiandbmrapp.utils.FitnessCalculations

class ResultsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentResultsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_results, container, false)

        val personData: PersonData

        arguments?.let {
            personData = PersonData(
                ResultsFragmentArgs.fromBundle(it).gender,
                ResultsFragmentArgs.fromBundle(it).age,
                ResultsFragmentArgs.fromBundle(it).height,
                ResultsFragmentArgs.fromBundle(it).weight
            )

            val fitnessCalculations = FitnessCalculations(personData)
            val bmi = fitnessCalculations.calculateBMI()
            val bmr = fitnessCalculations.calculateBMR()

            binding.bmiValueTextView.text = bmi.toString()
            binding.bmrValueTextView.text = "${bmr.toString()} Calories/day"
            binding.categoryResultTextView.text = fitnessCalculations.weightCategories()
        }

        setAnimations(binding)

        return binding.root
    }

    private fun setAnimations(binding: FragmentResultsBinding) {
        val speedOfDur: Long = 650

        animTextView(binding.bmrTextView, speedOfDur, -560f, 560f)
        animTextView(binding.bmrValueTextView, speedOfDur, -760f, 760f)

        animTextView(binding.bmiTextView, speedOfDur, 1260f, -1260f)
        animTextView(binding.bmiValueTextView, speedOfDur, 1060f, -1060f)
        animTextView(binding.categoryResultTextView, speedOfDur, 860f, -860f)
    }

    private fun animTextView(view: View, dur: Long, transY: Float, transYBy: Float) {
        view.translationY = transY
        view.animate().apply {
            duration = dur
            translationYBy(transYBy)
        }
    }

}