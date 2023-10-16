package com.example.step2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Chronometer
import androidx.lifecycle.ViewModelProvider
import com.example.step1.R

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel: ChronometerViewModel = ViewModelProvider(this).get(ChronometerViewModel::class.java)

        val chronometer: Chronometer = findViewById(R.id.chronometer)

        if(viewModel.getStartTime() == null ){
            var startTime = SystemClock.elapsedRealtime()
            viewModel.setStartTime(startTime)
            chronometer.base = startTime
        } else {
            chronometer.base = viewModel.getStartTime() ?: 0L
        }

        chronometer.start()
    }
}