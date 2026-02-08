package com.yugyd.quizmaker.di

import com.yugyd.viewmodeldelegates.ViewModelLogger
import org.koin.dsl.module

val mvvmLibraryModule = module {
    factory<ViewModelLogger> {
        ViewModelLoggerImpl(get())
    }
}
