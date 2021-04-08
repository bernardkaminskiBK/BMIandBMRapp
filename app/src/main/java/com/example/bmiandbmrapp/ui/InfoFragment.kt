package com.example.bmiandbmrapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.bmiandbmrapp.R
import com.example.bmiandbmrapp.databinding.FragmentInfoBinding


class InfoFragment : Fragment() {

    lateinit var binding: FragmentInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_info, container, false)

        setSeekBarProgressStats(binding.heightSeekBarTextView,binding.heightSeekBar)
        setSeekBarProgressStats(binding.weightSeekBarTextView,binding.weightSeekBar)
        calculateBmiAndBmr()
        increaseOneByOneSeekBar(binding.heightSeekBarTextView, binding.heightSeekBar, binding.imgBtnHeightPlusOne)
        increaseOneByOneSeekBar(binding.weightSeekBarTextView, binding.weightSeekBar, binding.imgBtnWeightPlusOne)

        return binding.root
    }

    private fun increaseOneByOneSeekBar(view: View, seekBar: SeekBar, imageButton: ImageButton) {
        view as TextView
        seekBar.progress = view.text.toString().toInt()
        imageButton.setOnClickListener {
            val num: Int = view.text.toString().toInt() + 1
            if (num <= seekBar.max) {
                view.text = num.toString()
                seekBar.progress = num
            }
        }
    }

    private fun setSeekBarProgressStats(view: View, seekBar: SeekBar) {
        view as TextView
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                view.setText(progress.toString())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
    }

    private fun calculateBmiAndBmr() {
        binding.btnCalculate.setOnClickListener { view: View ->

            val age = binding.ageEditTextNumber.text.toString()
            val weight = binding.weightSeekBarTextView.text.toString()
            val height = binding.heightSeekBarTextView.text.toString()
            val genderId = binding.btnRadioGenderGroup.checkedRadioButtonId
            val gender: String = whichGender(genderId)

            if (age.isEmpty() || age.toInt() < 15 || age.toInt() > 80) {
                Toast.makeText(context, "Please insert age between 15 and 80", Toast.LENGTH_LONG).show()
            } else {
                view.findNavController()
                    .navigate(
                        InfoFragmentDirections.actionInfoFragmentToResultsFragment(
                            age.toInt(),
                            weight.toInt(),
                            height.toInt(),
                            gender
                        )
                    )
            }
        }
    }

    private fun whichGender(
        genderId: Int
    ) = if (genderId == binding.radioButtonMan.id) {
        "man"
    } else {
        "woman"
    }

}