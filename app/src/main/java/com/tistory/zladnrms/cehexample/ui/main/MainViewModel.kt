package com.tistory.zladnrms.cehexample.ui.main

import androidx.lifecycle.viewModelScope
import com.tistory.zladnrms.cehexample.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class MainViewModel : BaseViewModel() {

    init {
        invokeException()
    }

    private fun invokeException() {
        viewModelScope.launch(ioDispatchers) {
            throw IllegalStateException()
        }
    }
}