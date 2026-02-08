package com.yugyd.quizmaker.core.navigation.api

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface RootNavKey : NavKey

@Serializable
data object HomeRoute : RootNavKey

@Serializable
data object ProfileRoute : RootNavKey

@Serializable
data class ContentRoute(val itemId: String) : NavKey
