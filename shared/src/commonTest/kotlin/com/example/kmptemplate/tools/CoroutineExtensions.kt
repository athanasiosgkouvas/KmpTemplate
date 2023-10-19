package com.example.kmptemplate.tools

import app.cash.turbine.ReceiveTurbine
import app.cash.turbine.test
import kotlinx.coroutines.flow.Flow

suspend fun <T> Flow<T>.runFlowTest(block: suspend ReceiveTurbine<T>.() -> Unit) {
    test {
        block()
        cancelAndConsumeRemainingEvents()
    }
}