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

package com.yugyd.quizmaker.designsystem.components.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.yugyd.quizmaker.designsystem.components.theme.QuizMakerTheme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import quizmaker.product.core.designsystem_components.generated.resources.Res
import quizmaker.product.core.designsystem_components.generated.resources.ds_components_content_description_icon_navigation_back
import quizmaker.product.core.designsystem_icons.generated.resources.ic_arrow_back
import quizmaker.product.core.designsystem_icons.generated.resources.Res as DsIconsRes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizTopAppBar(
    title: String,
    onBackClicked: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        },
        navigationIcon = {
            IconButton(onClick = onBackClicked) {
                Icon(
                    painter = painterResource(
                        resource = DsIconsRes.drawable.ic_arrow_back,
                    ),
                    contentDescription = stringResource(
                        resource = Res.string.ds_components_content_description_icon_navigation_back,
                    ),
                )
            }
        },
    )
}

@Preview
@Composable
private fun QuizTopAppBarPreview() {
    QuizMakerTheme {
        QuizTopAppBar(
            title = "Toolbar",
            onBackClicked = {},
        )
    }
}
