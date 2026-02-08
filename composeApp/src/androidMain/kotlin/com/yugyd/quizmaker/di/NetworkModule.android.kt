package com.yugyd.quizmaker.di

import com.yugyd.quizmaker.core.network.EngineFactory
import com.yugyd.quizmaker.core.network.NetworkClientProviderImpl
import com.yugyd.quizmaker.core.network.api.NetworkClientProvider
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

actual fun createNetworkModule() = module {
    factory<EngineFactory> {
        EngineFactory(context = androidContext())
    }

    factory<NetworkClientProvider> {
        NetworkClientProviderImpl(
            engineFactory = get(),
            appLogger = get(),
        )
    }
}
