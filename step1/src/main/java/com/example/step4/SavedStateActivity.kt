package com.example.step4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.step1.R

class SavedStateActivity : AppCompatActivity() {

    lateinit var mSavedStateViewModel: SavedStateViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saved_state)

        mSavedStateViewModel = ViewModelProvider(this).get(SavedStateViewModel::class.java)

        val tv = findViewById<TextView>(R.id.saved_vm_tv)

        mSavedStateViewModel.getName().observe(this
        ) { tv.text = getString(R.string.saved_in_vm, it)  }


        //저장 버튼
        findViewById<TextView>(R.id.save_bt).setOnClickListener {
            val newName = findViewById<EditText>(R.id.name_et).text.toString()
            mSavedStateViewModel.saveNewName(newName) // 입력된 값으로 저장
        }

    }
}