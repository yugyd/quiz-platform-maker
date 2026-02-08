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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.yugyd.quizmaker.content.ui.impl.ContentBinder.Model
import com.yugyd.quizmaker.content.ui.impl.ContentBinder.Model.NavigationUiState
import com.yugyd.quizmaker.content.ui.impl.models.ContentUiModel
import com.yugyd.quizmaker.designsystem.components.LoadingContent
import com.yugyd.quizmaker.designsystem.components.WarningContent
import com.yugyd.quizmaker.designsystem.components.component.QuizMakerBackground
import com.yugyd.quizmaker.designsystem.components.component.QuizTopAppBar
import com.yugyd.quizmaker.designsystem.components.effect.SnackbarMessageEffect
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import quizmaker.product.content_ui.generated.resources.Res
import quizmaker.product.content_ui.generated.resources.content_title
import quizmaker.product.core.designsystem_components.generated.resources.ds_error_base
import quizmaker.product.core.designsystem_components.generated.resources.Res as DsRes

@Composable
internal fun ContentScreen(
    binder: ContentBinder = koinViewModel(),
    snackbarHostState: SnackbarHostState,
    onNavigateToNext: () -> Unit,
    onBack: () -> Unit,
) {
    val state by binder.model.collectAsStateWithLifecycle()

    ContentScreen(
        state = state,
        snackbarHostState = snackbarHostState,
        onActionClicked = binder::onActionClicked,
        onBackClicked = binder::onBackClicked,
        onSnackbarDismissState = binder::onSnackbarDismissed,
        onBack = onBack,
        onNavigateToNext = onNavigateToNext,
        onNavigationHandled = binder::onNavigationHandled,
    )
}

@Composable
private fun ContentScreen(
    state: Model,
    snackbarHostState: SnackbarHostState,
    onActionClicked: () -> Unit,
    onNavigateToNext: () -> Unit,
    onSnackbarDismissState: () -> Unit,
    onBack: () -> Unit,
    onBackClicked: () -> Unit,
    onNavigationHandled: () -> Unit,
) {
    Column {
        QuizTopAppBar(
            title = stringResource(resource = Res.string.content_title),
            onBackClicked = onBackClicked,
        )

        when {
            state.isLoading -> {
                LoadingContent()
            }

            state.isWarning -> {
                WarningContent()
            }

            else -> {
                ContentContent(
                    uiModel = state.data,
                    onActionClicked = onActionClicked,
                )
            }
        }
    }

    SnackbarMessageEffect(
        message = stringResource(resource = DsRes.string.ds_error_base),
        showErrorMessage = state.showSnackbarMessage,
        snackbarHostState = snackbarHostState,
        onSnackbarDismissState = onSnackbarDismissState,
    )

    NavigationHandlerEffect(
        navigationState = state.navigationState,
        onNavigateToNext = onNavigateToNext,
        onBack = onBack,
        onNavigationHandled = onNavigationHandled,
    )
}

@Composable
private fun ContentContent(
    uiModel: ContentUiModel,
    onActionClicked: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp)
    ) {
        Text(text = uiModel.title)

        Spacer(modifier = Modifier.height(height = 16.dp))

        Text(text = uiModel.description)

        Spacer(modifier = Modifier.height(height = 8.dp))

        Button(
            onClick = onActionClicked,
        ) {
            Text(text = stringResource(resource = Res.string.content_title))
        }
    }
}

@Composable
private fun NavigationHandlerEffect(
    navigationState: NavigationUiState?,
    onNavigateToNext: () -> Unit,
    onBack: () -> Unit,
    onNavigationHandled: () -> Unit,
) {
    LaunchedEffect(key1 = navigationState) {
        when (navigationState) {
            is NavigationUiState.NavigateToNext -> onNavigateToNext()
            NavigationUiState.Back -> onBack()
            null -> Unit
        }

        navigationState?.let { onNavigationHandled() }
    }
}

@Preview
@Composable
private fun ContentContentPreview(
    @PreviewParameter(ContentPreviewParameterProvider::class) items: List<ContentUiModel>,
) {
    MaterialTheme {
        QuizMakerBackground {
            ContentContent(
                uiModel = items.first(),
                onActionClicked = {},
            )
        }
    }
}
