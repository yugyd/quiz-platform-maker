package com.yugyd.quizmaker.di

import com.yugyd.quizmaker.core.database.DatabaseProviderImpl
import com.yugyd.quizmaker.core.database.api.DatabaseProvider
import com.yugyd.quizmaker.core.localstorage.LocalStorageProviderImpl
import com.yugyd.quizmaker.core.localstorage.api.LocalStorageProvider
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual fun createStorageModule() = module {
    singleOf<LocalStorageProvider>(::LocalStorageProviderImpl)

    factory<DatabaseProvider> {
        DatabaseProviderImpl(dispatchersProvider = get())
    }
}
