package com.example.bmiandbmrapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.bmiandbmrapp.R
import com.example.bmiandbmrapp.databinding.FragmentWelcomeBinding
import com.example.bmiandbmrapp.utils.Animations


class WelcomeFragment : Fragment() {

    lateinit var binding: FragmentWelcomeBinding
    lateinit var buttonStart: Button
    lateinit var imageViewCalc: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)

        buttonStart = binding.btnStart
        imageViewCalc = binding.imageView2

        val animations = Animations()

        animations.welcomeImageAnim(imageViewCalc, 1000)
        animations.anim(binding.headLineTextView, -360f, 1000, 360f)
        animations.anim(buttonStart, 800f, 1000, -800f)

        buttonStart.setOnClickListener {
            it.findNavController()
                .navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInfoFragment())
        }

        imageViewCalc.setOnClickListener{
            animations.shower(imageViewCalc, layoutInflater.context)
        }

        return binding.root
    }

}