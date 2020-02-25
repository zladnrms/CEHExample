package com.tistory.zladnrms.cehexample.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.tistory.zladnrms.cehexample.utilities.SingleLiveEvent
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers

open class BaseViewModel: ViewModel() {

    protected val _apiFailEvent = SingleLiveEvent<Boolean>()
    val apiFailEvent: LiveData<Boolean> get() = _apiFailEvent

    /**
     * CoroutineScope 내부 Exception 처리 Handler
     */
    protected val coroutineExceptionHanlder = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
        _apiFailEvent.postCall()
    }

    /**
     * Dispatchers 선언 (Normal Dispatchers + CoroutineExceptionHandler)
     */
    protected val ioDispatchers = Dispatchers.IO + coroutineExceptionHanlder
}