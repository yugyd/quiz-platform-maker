package com.yugyd.quizmaker.di

fun appModule() = listOf(
    loggerModule,
    mvvmLibraryModule,
    threadingModule,
    createStorageModule(),
    createNetworkModule(),
)
    .plus(featuresModule)
