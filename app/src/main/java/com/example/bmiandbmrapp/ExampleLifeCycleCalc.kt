package com.example.bmiandbmrapp

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class ExampleLifeCycleCalc(lifecycle: Lifecycle) : LifecycleObserver {

    init {
        lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun startCalculation() {
        Log.i("MainActivity", "startCalculation was called")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stopCalculation() {
        Log.i("MainActivity", "stopCalculation was called")
    }

}