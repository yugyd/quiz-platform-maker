package com.yugyd.quizmaker.di

fun appModule() = listOf(
    loggerModule,
    threadingModule,
    createStorageModule()
)
