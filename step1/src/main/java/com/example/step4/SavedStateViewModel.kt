package com.example.step4

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SavedStateViewModel : ViewModel() {

    private var name: MutableLiveData<String> = MutableLiveData()

    // immutable data 노출
    fun getName(): LiveData<String> = name

    fun saveNewName(newName: String) {
        name.value = newName
    }

}