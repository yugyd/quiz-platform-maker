package com.yugyd.quizmaker.content.domain.impl

import com.yugyd.quizmaker.content.domain.api.ContentViewModel
import com.yugyd.quizmaker.content.domain.api.ContentViewModel.Event
import com.yugyd.quizmaker.content.domain.api.ContentViewModel.State
import com.yugyd.quizmaker.content.domain.api.ContentViewModel.State.NavigationState
import com.yugyd.quizmaker.core.coroutines.DispatchersProvider
import com.yugyd.quizmaker.core.coroutines.result
import com.yugyd.quizmaker.core.logger.api.Logger
import com.yugyd.viewmodeldelegates.SimpleViewModel
import com.yugyd.viewmodeldelegates.ViewModelLogger
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

internal class ContentViewModelImpl(
    private val repository: ContentRepository,
    private val logger: Logger,
    initialState: State,
    dispatchersProvider: DispatchersProvider,
    viewModelLogger: ViewModelLogger?,
) :
    SimpleViewModel<Event, State>(
        initialState = initialState,
        mainImmediateCoroutineDispatcher = dispatchersProvider.main,
        logger = viewModelLogger,
        name = "ContentViewModel",
        initEvents = setOf(Event.LoadContent, Event.SubscribeToContent),
    ),
    ContentViewModel {

    override fun doInit() {
        updateState {
            it.copy(showSnackbarMessage = true)
        }
    }

    override fun acceptEvent(event: Event) {
        when (event) {
            Event.LoadContent -> {
                updateState {
                    it.copy(
                        isLoading = true,
                        isWarning = false,
                    )
                }

                viewModelScope.launch {
                    val currentState = state.value
                    val id = currentState.arguments.id

                    result {
                        repository.fetchData(id = id)
                    }
                        .onFailure { error ->
                            logger.logError(error)

                            updateState {
                                it.copy(
                                    isLoading = false,
                                    isWarning = true,
                                )
                            }
                        }
                        .onSuccess {
                            updateState {
                                it.copy(
                                    isLoading = false,
                                    isWarning = false,
                                )
                            }
                        }
                }
            }

            Event.SubscribeToContent -> {
                viewModelScope.launch {
                    updateState { it.copy(data = null) }

                    val currentState = state.value
                    val id = currentState.arguments.id

                    repository
                        .subscribeToData(id = id)
                        .catch { error ->
                            logger.logError(error)

                            updateState { it.copy(data = null) }
                        }
                        .collect { newData ->
                            updateState { it.copy(data = newData) }
                        }
                }
            }

            Event.OnActionClicked -> {
                updateState {
                    it.copy(navigationState = NavigationState.NavigateToFavourites)
                }
            }

            Event.OnNavigationHandled -> {
                updateState {
                    it.copy(navigationState = null)
                }
            }

            Event.OnSnackbarDismissed -> {
                updateState {
                    it.copy(showSnackbarMessage = false)
                }
            }

            Event.OnBackClicked -> {
                updateState {
                    it.copy(navigationState = NavigationState.Back)
                }
            }
        }
    }
}
