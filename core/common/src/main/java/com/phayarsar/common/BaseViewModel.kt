package com.phayarsar.common

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

abstract class BaseViewModel<E> : ViewModel() {

    private var _navigationEvent = MutableSharedFlow<E>()
    val navigationEvent: SharedFlow<E> = _navigationEvent.asSharedFlow()

     suspend fun emitEvent(event: E) {
             _navigationEvent.emit(event)
    }
}