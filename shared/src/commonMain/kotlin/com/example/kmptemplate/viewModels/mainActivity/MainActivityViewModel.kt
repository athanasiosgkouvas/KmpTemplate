package com.example.kmptemplate.viewModels.mainActivity

import com.example.kmptemplate.mvi.BaseViewModel
import com.example.kmptemplate.mvi.UiEffect
import com.example.kmptemplate.mvi.UiEvent
import com.example.kmptemplate.mvi.UiState

interface MainActivityContract{
    sealed interface Event: UiEvent{
        data object OnButtonClicked: Event
    }

    data class State(val message: String = ""): UiState

    sealed interface Effect: UiEffect{
        data object ShowSnackBar: Effect
    }
}

open class MainActivityViewModel: BaseViewModel<MainActivityContract.Event, MainActivityContract.State, MainActivityContract.Effect>(){
    override fun createInitialState(): MainActivityContract.State  = MainActivityContract.State()

    override fun handleEvent(event: MainActivityContract.Event) {
        when(event){
            MainActivityContract.Event.OnButtonClicked -> {
                setState {
                    copy(
                        message = "Hello World!"
                    )
                }
                setEffect { MainActivityContract.Effect.ShowSnackBar }
            }
        }
    }

}