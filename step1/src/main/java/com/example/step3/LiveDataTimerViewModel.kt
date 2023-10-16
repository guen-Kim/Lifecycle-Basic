package com.example.step3

import android.os.SystemClock
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Timer
import java.util.TimerTask

class LiveDataTimerViewModel : ViewModel() {


    private val ONE_SECOND = 1000L

    private var mElapsedTime = MutableLiveData<Long>()

    private var mInitialTime: Long = SystemClock.elapsedRealtime()

    private val timer: Timer = Timer()

    init {
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                val newValue = (SystemClock.elapsedRealtime() - mInitialTime) / 1000

                //  MutableLiveData.setValue() 는 오로지 MainThread 에서만 호출 가능!
                mElapsedTime.postValue(newValue)
            }
        }, ONE_SECOND, ONE_SECOND)
    }

    fun getElapsedTime(): LiveData<Long> {
        return mElapsedTime
    }

    override fun onCleared() {
        super.onCleared()
        // ViewModel 리소스 해제
        timer.cancel()
    }
}

