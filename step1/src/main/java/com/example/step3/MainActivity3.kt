package com.example.step3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.step1.R

class MainActivity3 : AppCompatActivity() {


    private lateinit var mLiveDataTimerViewModel: LiveDataTimerViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val timer: TextView = findViewById(R.id.tv_timer)

        mLiveDataTimerViewModel = ViewModelProvider(this).get(LiveDataTimerViewModel::class.java)


        subscribe(timer)

    }

    private fun subscribe(timer: TextView) {
        val elapsedTimeObserver = Observer<Long> {
            var newText = resources.getString(R.string.seconds, it)
            timer.text = newText
        }
        mLiveDataTimerViewModel.getElapsedTime().observe(this, elapsedTimeObserver)
    }
}