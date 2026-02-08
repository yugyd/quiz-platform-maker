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

package com.yugyd.quizmaker.content.ui.factory

import androidx.compose.material3.SnackbarHostState
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.yugyd.quizmaker.content.domain.api.models.ContentArguments
import com.yugyd.quizmaker.content.ui.impl.ContentScreen
import com.yugyd.quizmaker.core.navigation.QuizMakerNavigator
import com.yugyd.quizmaker.core.navigation.api.ContentRoute
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

fun QuizMakerNavigator.navigateToContent(itemId: String) {
    navigate(
        route = ContentRoute(
            itemId = itemId,
        ),
    )
}

fun EntryProviderScope<NavKey>.contentScreen(
    snackbarHostState: SnackbarHostState,
    onNavigateToNext: () -> Unit,
    onBack: () -> Unit,
) {
    entry<ContentRoute> {
        ContentScreen(
            binder = koinViewModel(
                parameters = { parametersOf(ContentArguments(id = it.itemId)) }
            ),
            snackbarHostState = snackbarHostState,
            onNavigateToNext = onNavigateToNext,
            onBack = onBack,
        )
    }
}
