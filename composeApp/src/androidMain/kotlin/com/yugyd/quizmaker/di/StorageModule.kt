package com.yugyd.quizmaker.di

import com.yugyd.quizmaker.core.database.DatabaseProviderImpl
import com.yugyd.quizmaker.core.database.api.DatabaseProvider
import com.yugyd.quizmaker.core.localstorage.LocalStorageProviderImpl
import com.yugyd.quizmaker.core.localstorage.api.LocalStorageProvider
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

actual fun createStorageModule() = module {
    single<LocalStorageProvider> {
        LocalStorageProviderImpl(context = androidContext())
    }

    factory<DatabaseProvider> {
        DatabaseProviderImpl(
            context = androidContext(),
            dispatchersProvider = get(),
        )
    }
}
