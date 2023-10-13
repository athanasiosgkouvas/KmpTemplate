package com.example.kmptemplate.mvi

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

/**
 * Base class that provides a Kotlin/Native equivalent to the AndroidX `ViewModel`.
 */
actual abstract class ViewModel actual constructor() {

    /**
     * Override this to do any cleanup immediately before the internal [CoroutineScope][kotlinx.coroutines.CoroutineScope]
     * is cancelled.
     */
    protected actual open fun onCleared() {
    }

    fun clear() {
        onCleared()
    }

    actual val viewModelScope: CoroutineScope
        get() = CoroutineScope(SupervisorJob() + Dispatchers.Main)
}