package com.example.bmiandbmrapp

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.DataBindingUtil
import com.example.bmiandbmrapp.databinding.FragmentWelcomeBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("MainActivity", "Pustam onCreate()")

        val exampleLifeCycleCalc = ExampleLifeCycleCalc(this.lifecycle)

    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "Pustam onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "Pustam onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity", "Pustam onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity", "Pustam onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity", "Pustam onDestroy()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MainActivity", "Pustam onRestart()")
    }

}