package com.yugyd.quizmaker.main.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.yugyd.quizmaker.core.navigation.Navigator
import com.yugyd.quizmaker.core.navigation.api.Home
import com.yugyd.quizmaker.core.navigation.api.Profile
import com.yugyd.quizmaker.core.navigation.rememberNavigationState
import com.yugyd.quizmaker.core.navigation.toEntries
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun MainScreen() {
    val navigationState = rememberNavigationState(
        startRoute = Home,
        topLevelRoutes = TOP_LEVEL_DESTINATIONS.keys,
    )

    val navigator = remember { Navigator(navigationState) }

    val entryProvider = entryProvider<NavKey> {
        entry<Home> {
            HomeRoute(
                goToProfile = {
                    navigator.navigate(Profile)
                }
            )
        }

        entry<Profile> {
            ProfileRoute()
        }
    }

    Scaffold(
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
            modifier = Modifier.padding(paddingValues),
        )
    }
}
