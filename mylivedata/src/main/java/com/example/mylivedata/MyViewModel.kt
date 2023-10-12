package com.example.mylivedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {


    /*LiveData 객체 생성*/
    val currentName: MutableLiveData<String> by lazy {
        // 불필요한 리소스 소비 방지
        MutableLiveData<String>()
    }


    /* 다음의 방식 권장됨 */
    // 은닉화, 클래스 내부에서만 변경할 수 있는  MutableLiveData
    private val _currentAge = MutableLiveData<Int>()
    // 외부에 노출되는 변경 불가능한 LiveData
    val currentAge: LiveData<Int> = _currentAge


    fun loadData() {
        currentName.value = "guen" // onChanged()
        _currentAge.postValue(33)// onChanged()
    }
}