package com.example.mylifecycle

import android.app.Activity
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
class ExampleActivity : Activity(), LifecycleOwner {
    //lifecycle 객체 선언
    private lateinit var lifecycleRegistry: LifecycleRegistry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleRegistry = LifecycleRegistry(this)

        //Lifecycle 객체 획득
        //addObserver를 사용하여 Owner에 Observer 추가
        lifecycleRegistry.addObserver(MyObserver())
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }
}