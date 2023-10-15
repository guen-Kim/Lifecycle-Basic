package com.example.mylivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv1 = findViewById<TextView>(R.id.tv_name)
        val tv2 = findViewById<TextView>(R.id.tv_age)


        // 'by viewModels() 를 사용하여 Kotlin 프로퍼티를 위임'
        // activity-ktx artifact
        val model : MyViewModel by viewModels()

        val nameObserver = Observer<String> { newName ->
            tv1.text = newName
        }

        val ageOserver = Observer<Int> { age ->
            tv2.text = age.toString()
        }


        // liveData observer 등록
        model.currentName.observe(this, nameObserver)
        model.currentAge.observe(this, ageOserver)
        model.loadData()
    }
}