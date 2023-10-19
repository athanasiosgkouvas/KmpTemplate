package com.example.kmptemplate.viewModels

import com.example.kmptemplate.tools.runFlowTest
import com.example.kmptemplate.viewModels.mainActivity.MainActivityContract
import com.example.kmptemplate.viewModels.mainActivity.MainActivityViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

internal class TestMainActivityViewModel {
    private lateinit var viewModel: MainActivityViewModel
    private val initialState = MainActivityContract.State()

    @BeforeTest
    fun before() {
        Dispatchers.setMain(StandardTestDispatcher())
        viewModel = MainActivityViewModel()
    }

    @Test
    fun `WHEN viewModel OnButtonClicked THEN state updated and ShowSnackBar effect emitted`() =
        runTest {
            viewModel.setEvent(MainActivityContract.Event.OnButtonClicked)

            advanceUntilIdle()
            assertEquals(
                initialState.copy(
                    message = "Hello World!"
                ),
                viewModel.uiState.value
            )

            viewModel.effect.runFlowTest {
                assertEquals(MainActivityContract.Effect.ShowSnackBar, awaitItem())
            }
        }

    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain() // reset the main dispatcher to the original Main dispatcher
    }
}
