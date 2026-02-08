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

import com.yugyd.quizmaker.content.domain.api.ContentViewModel.State
import com.yugyd.quizmaker.content.domain.api.ContentViewModel.State.NavigationState
import com.yugyd.quizmaker.content.domain.api.models.ContentModel
import com.yugyd.quizmaker.content.ui.impl.ContentBinder.Model
import com.yugyd.quizmaker.content.ui.impl.ContentBinder.Model.NavigationUiState
import com.yugyd.quizmaker.content.ui.impl.models.ContentUiModel
import com.yugyd.viewmodeldelegates.ui.StateToModelMapper

internal class ContentMapper : StateToModelMapper<State, Model> {

    override fun map(state: State): Model {
        val data = if (state.data != null) {
            state.data!!.toUiModel()
        } else {
            ContentUiModel()
        }
        return Model(
            isLoading = state.isLoading,
            isWarning = state.isWarning,
            data = data,
            showSnackbarMessage = state.showSnackbarMessage,
            navigationState = state.navigationState.mapToNavigationUiState(),
        )
    }

    private fun ContentModel.toUiModel(): ContentUiModel {
        return ContentUiModel(
            title = title,
            description = description,
        )
    }

    private fun NavigationState?.mapToNavigationUiState(): NavigationUiState? {
        return when (this) {
            is NavigationState.NavigateToFavourites -> NavigationUiState.NavigateToNext
            NavigationState.Back -> NavigationUiState.Back
            null -> null
        }
    }
}
