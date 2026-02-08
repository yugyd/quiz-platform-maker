package com.yugyd.quizmaker.content.domain.factory

import com.yugyd.quizmaker.content.domain.api.ContentViewModel
import com.yugyd.quizmaker.content.domain.api.models.ContentArguments
import com.yugyd.quizmaker.content.domain.impl.ContentRepository
import com.yugyd.quizmaker.content.domain.impl.ContentViewModelFactory
import com.yugyd.quizmaker.content.domain.impl.data.ContentDao
import com.yugyd.quizmaker.content.domain.impl.data.ContentInMemoryStorage
import com.yugyd.quizmaker.content.domain.impl.data.ContentInMemoryStorageImpl
import com.yugyd.quizmaker.content.domain.impl.data.ContentLocalStorage
import com.yugyd.quizmaker.content.domain.impl.data.ContentLocalStorageImpl
import com.yugyd.quizmaker.content.domain.impl.data.ContentRemoteSource
import com.yugyd.quizmaker.content.domain.impl.data.ContentRemoteSourceImpl
import com.yugyd.quizmaker.content.domain.impl.data.ContentRepositoryImpl
import com.yugyd.quizmaker.content.domain.impl.data.mappers.ContentEntityMapper
import com.yugyd.quizmaker.content.domain.impl.data.mappers.ContentLocalEntityMapper
import com.yugyd.quizmaker.content.domain.impl.data.mappers.ContentRemoteMapper
import com.yugyd.quizmaker.content.domain.impl.data.models.ContentEntity
import org.koin.core.module.dsl.factoryOf
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

fun buildContentBlComponent() = module {
    // data
    factoryOf(::ContentEntityMapper)
    factoryOf(::ContentLocalEntityMapper)
    factoryOf(::ContentRemoteMapper)

    // stub in production, real implementation will be provided from database module
    factory<ContentDao> {
        object : ContentDao {
            override fun observeById(id: String) = throw NotImplementedError()
            override suspend fun getById(id: String) = throw NotImplementedError()
            override suspend fun update(entity: ContentEntity) = throw NotImplementedError()
        }
    }

    single<ContentInMemoryStorage> {
        ContentInMemoryStorageImpl()
    }
    single<ContentLocalStorage> {
        ContentLocalStorageImpl(get(), get(), get())
    }
    factory<ContentRemoteSource> {
        ContentRemoteSourceImpl(get())
    }

    factory<ContentRepository> {
        ContentRepositoryImpl(
            get(),
            get(),
            get(),
            get(),
            get(),
            get(),
            get(),
            get()
        )
    }

    // domain
    factory<ContentViewModelFactory> { params ->
        ContentViewModelFactory(
            params.get<ContentArguments>(),
            get(),
            get(),
            get(),
            get(),
        )
    }

    factory<ContentViewModel> { params ->
        get<ContentViewModelFactory> {
            parametersOf(params.get<ContentArguments>())
        }
            .create()
    }
}
