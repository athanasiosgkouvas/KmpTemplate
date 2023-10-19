package com.example.kmptemplate.tools

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

fun <T> T.toFlow(): StateFlow<T> =
    MutableStateFlow(this).asStateFlow()