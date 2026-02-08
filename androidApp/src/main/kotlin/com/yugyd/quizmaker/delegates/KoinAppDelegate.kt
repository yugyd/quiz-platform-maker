package com.yugyd.quizmaker.delegates

import com.yugyd.quizmaker.di.appModule
import com.yugyd.quizmaker.di.platformModule
import org.koin.core.context.startKoin

class KoinAppDelegate() : AppDelegate {

    override fun init() {
        startKoin {
            modules(appModule() + platformModule)
        }
    }
}
