package com.example.kmptemplate.viewModels.mainActivity

import com.example.kmptemplate.mvi.BaseViewModel
import com.example.kmptemplate.mvi.UiEffect
import com.example.kmptemplate.mvi.UiEvent
import com.example.kmptemplate.mvi.UiState

interface MainActivityContract{
    sealed interface Event: UiEvent

    data class State(val message: String = "Hello World!"): UiState

    sealed interface Effect: UiEffect
}

open class MainActivityViewModel: BaseViewModel<MainActivityContract.Event, MainActivityContract.State, MainActivityContract.Effect>(){
    override fun createInitialState(): MainActivityContract.State  = MainActivityContract.State()

    override fun handleEvent(event: MainActivityContract.Event) {
        TODO("Not yet implemented")
    }

}