package com.example.bmiandbmrapp.utils

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import com.example.bmiandbmrapp.R

class Animations {

    fun anim(view: View, transY: Float, dur: Long, transByY: Float) {
        view.translationY = transY
        view.animate().apply {
            duration = dur
            translationYBy(transByY)
        }
    }

    fun welcomeImageAnim(imageView: ImageView, dur: Long) {
        imageView.animate().apply {
            duration = dur
            rotationYBy(3600f)
        }.withEndAction {
            imageView.animate().apply {
                duration = dur
                rotationYBy(360f)
            }
        }
    }

    fun shower(view: View, context: Context) {
        val container = view.parent as ViewGroup
        val containerW = container.width
        val containerH = container.height
        var imgW: Float = view.width.toFloat()
        var imgH: Float = view.height.toFloat()

        val newImg = AppCompatImageView(context)
        newImg.setImageResource(R.drawable.ic_calculator_flat)
        newImg.layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.WRAP_CONTENT,
            FrameLayout.LayoutParams.WRAP_CONTENT)
        container.addView(newImg)

        newImg.scaleX = Math.random().toFloat() * 1.5f + .1f
        newImg.scaleY = newImg.scaleX
        imgW *= newImg.scaleX
        imgH *= newImg.scaleY

        newImg.translationX = Math.random().toFloat() *
                containerW - imgW / 2

        val mover = ObjectAnimator.ofFloat(newImg, View.TRANSLATION_Y,
            -imgH, containerH + imgH)
        mover.interpolator = AccelerateInterpolator(1f)
        val rotator = ObjectAnimator.ofFloat(newImg, View.ROTATION,
            (Math.random() * 1080).toFloat())
        rotator.interpolator = LinearInterpolator()

        val set = AnimatorSet()
        set.playTogether(mover, rotator)
        set.duration = (Math.random() * 1500 + 500).toLong()

        set.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                container.removeView(newImg)
            }
        })
        set.start()
    }
}