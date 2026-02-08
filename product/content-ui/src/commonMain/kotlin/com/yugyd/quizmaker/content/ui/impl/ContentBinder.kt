/*
 *    Copyright 2025 Roman Likhachev
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.yugyd.quizmaker.content.ui.impl

import com.yugyd.quizmaker.content.domain.api.ContentViewModel
import com.yugyd.quizmaker.content.domain.api.ContentViewModel.Event
import com.yugyd.quizmaker.content.domain.api.ContentViewModel.State
import com.yugyd.quizmaker.content.ui.impl.ContentBinder.Model
import com.yugyd.quizmaker.content.ui.impl.models.ContentUiModel
import com.yugyd.quizmaker.core.coroutines.DispatchersProvider
import com.yugyd.viewmodeldelegates.ui.ModelViewModelBinder

internal class ContentBinder(
    private val viewModel: ContentViewModel,
    mapper: ContentMapper,
    dispatchersProvider: DispatchersProvider,
) : ModelViewModelBinder<Event, State, Model>(
    viewModel = viewModel,
    initialModel = Model(),
    stateToModelMapper = mapper,
    mainImmediateCoroutineDispatcher = dispatchersProvider.main,
) {

    fun onActionClicked() {
        viewModel.accept(Event.OnActionClicked)
    }

    fun onBackClicked() {
        viewModel.accept(Event.OnBackClicked)
    }

    fun onSnackbarDismissed() {
        viewModel.accept(Event.OnSnackbarDismissed)
    }

    fun onNavigationHandled() {
        viewModel.accept(Event.OnNavigationHandled)
    }

    data class Model(
        val isLoading: Boolean = false,
        val isWarning: Boolean = false,
        val data: ContentUiModel = ContentUiModel(),
        val showSnackbarMessage: Boolean = false,
        val navigationState: NavigationUiState? = null,
    ) {

        sealed interface NavigationUiState {
            object NavigateToNext : NavigationUiState
            object Back : NavigationUiState
        }
    }
}
