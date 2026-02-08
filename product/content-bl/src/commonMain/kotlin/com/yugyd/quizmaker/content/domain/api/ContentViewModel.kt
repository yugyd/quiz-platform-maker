package com.yugyd.quizmaker.content.domain.api

import com.yugyd.quizmaker.content.domain.api.ContentViewModel.Event
import com.yugyd.quizmaker.content.domain.api.ContentViewModel.State
import com.yugyd.quizmaker.content.domain.api.models.ContentArguments
import com.yugyd.quizmaker.content.domain.api.models.ContentModel
import com.yugyd.viewmodeldelegates.ViewModel

interface ContentViewModel : ViewModel<Event, State> {

    sealed interface Event {
        object LoadContent : Event
        object SubscribeToContent : Event
        object OnActionClicked : Event
        object OnBackClicked : Event
        object OnSnackbarDismissed : Event
        object OnNavigationHandled : Event
    }

    data class State(
        val arguments: ContentArguments = ContentArguments(),
        val isLoading: Boolean = false,
        val isWarning: Boolean = false,
        val data: ContentModel? = null,
        val showSnackbarMessage: Boolean = false,
        val navigationState: NavigationState? = null,
    ) {

        sealed interface NavigationState {
            object Back : NavigationState
            object NavigateToFavourites : NavigationState
        }
    }
}
