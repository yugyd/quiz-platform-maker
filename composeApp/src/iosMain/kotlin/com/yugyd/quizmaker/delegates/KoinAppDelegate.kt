package com.yugyd.quizmaker.delegates

import com.yugyd.quizmaker.di.appModule
import org.koin.core.context.startKoin

internal class KoinAppDelegate() : AppDelegate {

    override fun init() {
        startKoin {
            modules(appModule())
        }
    }
}
