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

import com.yugyd.quizmaker.content.domain.api.models.ContentArguments
import com.yugyd.quizmaker.content.domain.factory.buildContentBlComponent
import com.yugyd.quizmaker.content.ui.impl.ContentBinder
import com.yugyd.quizmaker.content.ui.impl.ContentMapper
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

fun buildContentUiComponent() = listOf(
    buildContentBlComponent(),
    module {
        factoryOf(::ContentMapper)

        viewModel { params ->
            ContentBinder(
                get {
                    val args = params.get<ContentArguments>()
                    parametersOf(args)
                },
                get(),
                get()
            )
        }
    },
)
