package com.yugyd.quizmaker.core.navigation.api

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface RootNavKey : NavKey

@Serializable
data object Home : RootNavKey

@Serializable
data object Profile : RootNavKey
