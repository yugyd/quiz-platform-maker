package com.yugyd.quizmaker.di

import com.yugyd.quizmaker.core.coroutines.DispatchersProvider
import com.yugyd.quizmaker.core.coroutines.DispatchersProviderImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val threadingModule = module {
    factoryOf<DispatchersProvider>(::DispatchersProviderImpl)
}
