package com.example.step2

import androidx.lifecycle.ViewModel

class ChronometerViewModel : ViewModel() {
    private var mStartTime: Long? = null

    fun getStartTime() = mStartTime
    fun setStartTime(time: Long) {
        mStartTime = time
    }

}