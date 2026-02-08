package com.yugyd.quizmaker.main.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.yugyd.quizmaker.content.ui.factory.contentScreen
import com.yugyd.quizmaker.content.ui.factory.navigateToContent
import com.yugyd.quizmaker.core.navigation.QuizMakerNavigator
import com.yugyd.quizmaker.core.navigation.api.HomeRoute
import com.yugyd.quizmaker.core.navigation.api.ProfileRoute
import com.yugyd.quizmaker.core.navigation.rememberNavigationState
import com.yugyd.quizmaker.core.navigation.toEntries
import com.yugyd.quizmaker.designsystem.components.component.QuizMakerBackground
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun MainScreen() {
    val navigationState = rememberNavigationState(
        startRoute = HomeRoute,
        topLevelRoutes = TOP_LEVEL_DESTINATIONS.keys,
    )

    val navigator = remember {
        QuizMakerNavigator(navigationState)
    }

    val snackbarHostState = remember {
        SnackbarHostState()
    }

    val entryProvider = entryProvider {
        entry<HomeRoute> {
            HomeScreen(
                goToContent = {
                    navigator.navigateToContent(it)
                },
            )
        }

        entry<ProfileRoute> {
            ProfileScreen()
        }

        contentScreen(
            snackbarHostState = snackbarHostState,
            onNavigateToNext = {
                println("Navigate to next clicked")
            },
            onBack = {
                navigator.goBack()
            },
        )
    }

    QuizMakerBackground {
        Scaffold(
            snackbarHost = {
                SnackbarHost(snackbarHostState)
            },
            bottomBar = {
                NavigationBar {
                    TOP_LEVEL_DESTINATIONS.forEach { (key, value) ->
                        val isSelected = key == navigationState.topLevelRoute
                        NavigationBarItem(
                            selected = isSelected,
                            onClick = { navigator.navigate(key) },
                            icon = {
                                Icon(
                                    imageVector = vectorResource(value.icon),
                                    contentDescription = stringResource(value.description),
                                )
                            },
                            label = {
                                Text(
                                    text = stringResource(value.description),
                                )
                            }
                        )
                    }
                }
            }
        ) { paddingValues ->
            NavDisplay(
                entries = navigationState.toEntries(entryProvider),
                onBack = { navigator.goBack() },
                modifier = Modifier.fillMaxSize().padding(paddingValues),
            )
        }
    }
}
