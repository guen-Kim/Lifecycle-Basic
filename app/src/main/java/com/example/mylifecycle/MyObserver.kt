package com.example.mylifecycle

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

// DefaultLifecycleObserver 인터페이스 구현
class MyObserver : DefaultLifecycleObserver {

    // lifecycle callback 메서드 구현
    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.d("MyLifecycle", "onCreate")
    }


    override fun onResume(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.d("MyLifecycle", "onResume")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.d("MyLifecycle", "onStart")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.d("MyLifecycle", "onPause")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.d("MyLifecycle", "onStop")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.d("MyLifecycle", "onDestroy")

    }
}