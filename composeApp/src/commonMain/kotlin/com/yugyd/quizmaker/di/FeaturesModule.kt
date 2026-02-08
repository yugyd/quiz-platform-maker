package com.yugyd.quizmaker.di

import com.yugyd.quizmaker.content.ui.factory.buildContentUiComponent

val featuresModule = buildList {
    addAll(buildContentUiComponent())
}
