package com.yugyd.quizmaker.main.ui

import androidx.navigation3.runtime.NavKey
import com.yugyd.quizmaker.core.navigation.NavBarItem
import com.yugyd.quizmaker.core.navigation.api.Home
import com.yugyd.quizmaker.core.navigation.api.Profile
import quizmaker.product.main_ui.generated.resources.Res
import quizmaker.product.main_ui.generated.resources.ic_account_circle
import quizmaker.product.main_ui.generated.resources.ic_menu_book
import quizmaker.product.main_ui.generated.resources.nav_home
import quizmaker.product.main_ui.generated.resources.nav_profile

val TOP_LEVEL_DESTINATIONS = mapOf<NavKey, NavBarItem>(
    Home to NavBarItem(
        icon = Res.drawable.ic_menu_book,
        description = Res.string.nav_home,
    ),
    Profile to NavBarItem(
        icon = Res.drawable.ic_account_circle,
        description = Res.string.nav_profile,
    ),
)
