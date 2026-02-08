package com.yugyd.quizmaker.main.ui

import androidx.navigation3.runtime.NavKey
import com.yugyd.quizmaker.core.navigation.NavBarItem
import com.yugyd.quizmaker.core.navigation.api.HomeRoute
import com.yugyd.quizmaker.core.navigation.api.ProfileRoute
import quizmaker.product.main_ui.generated.resources.Res
import quizmaker.product.main_ui.generated.resources.ic_account_circle
import quizmaker.product.main_ui.generated.resources.ic_menu_book
import quizmaker.product.main_ui.generated.resources.nav_home
import quizmaker.product.main_ui.generated.resources.nav_profile

val TOP_LEVEL_DESTINATIONS = mapOf<NavKey, NavBarItem>(
    HomeRoute to NavBarItem(
        icon = Res.drawable.ic_menu_book,
        description = Res.string.nav_home,
    ),
    ProfileRoute to NavBarItem(
        icon = Res.drawable.ic_account_circle,
        description = Res.string.nav_profile,
    ),
)
