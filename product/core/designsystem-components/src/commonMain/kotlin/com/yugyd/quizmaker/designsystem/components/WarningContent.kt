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

package com.yugyd.quizmaker.designsystem.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yugyd.quizmaker.designsystem.components.theme.QuizMakerTheme
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import quizmaker.product.core.designsystem_components.generated.resources.Res
import quizmaker.product.core.designsystem_components.generated.resources.ds_empty_state_description
import quizmaker.product.core.designsystem_components.generated.resources.ds_empty_state_retry
import quizmaker.product.core.designsystem_components.generated.resources.ds_empty_state_title
import quizmaker.product.core.designsystem_components.generated.resources.ic_cloud_off

@Composable
fun WarningContent(
    modifier: Modifier = Modifier,
    retryTitle: String? = null,
    isRetryButtonEnabled: Boolean = false,
    onRetryClicked: (() -> Unit)? = null,
) {
    WarningContent(
        icon = Res.drawable.ic_cloud_off,
        title = stringResource(resource = Res.string.ds_empty_state_title),
        message = stringResource(resource = Res.string.ds_empty_state_description),
        modifier = modifier,
        retryTitle = retryTitle,
        isRetryButtonEnabled = isRetryButtonEnabled,
        onRetryClicked = onRetryClicked,
    )
}

@Composable
fun WarningContent(
    icon: DrawableResource,
    message: String,
    modifier: Modifier = Modifier,
    title: String = stringResource(resource = Res.string.ds_empty_state_title),
    retryTitle: String? = null,
    isRetryButtonEnabled: Boolean = false,
    onRetryClicked: (() -> Unit)? = null,
) {
    Column(
        modifier = modifier.then(
            Modifier
                .padding(16.dp)
                .fillMaxSize(),
        ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = Modifier.size(64.dp),
            painter = painterResource(resource = icon),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground),
            contentDescription = null,
        )

        Spacer(modifier = Modifier.height(48.dp))

        Text(
            text = title,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = message,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
        )

        if (isRetryButtonEnabled && onRetryClicked != null) {
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onRetryClicked,
                enabled = isRetryButtonEnabled,
            ) {
                Text(
                    text = retryTitle ?: stringResource(resource = Res.string.ds_empty_state_retry),
                )
            }
        }
    }
}

@Preview
@Composable
fun WarningContentPreview() {
    QuizMakerTheme {
        Surface {
            WarningContent()
        }
    }
}

@Preview
@Composable
fun WarningWithButtonContentPreview() {
    QuizMakerTheme {
        Surface {
            WarningContent(
                isRetryButtonEnabled = true,
                onRetryClicked = {},
            )
        }
    }
}
