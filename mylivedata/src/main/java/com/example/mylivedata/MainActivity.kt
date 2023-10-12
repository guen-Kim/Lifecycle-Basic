package com.example.mylivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var model: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv1 = findViewById<TextView>(R.id.tv_name)
        val tv2 = findViewById<TextView>(R.id.tv_age)


        // 뷰모델 초기화
        model = ViewModelProvider(this).get(MyViewModel::class.java)

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