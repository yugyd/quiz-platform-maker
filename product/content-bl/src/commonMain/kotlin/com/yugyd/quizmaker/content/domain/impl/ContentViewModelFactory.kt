package com.yugyd.quizmaker.content.domain.impl

import com.yugyd.quizmaker.content.domain.api.ContentViewModel
import com.yugyd.quizmaker.content.domain.api.ContentViewModel.State
import com.yugyd.quizmaker.content.domain.api.models.ContentArguments
import com.yugyd.quizmaker.core.coroutines.DispatchersProvider
import com.yugyd.quizmaker.core.logger.api.Logger
import com.yugyd.quizmaker.core.viewmodel.api.BaseViewModelFactory
import com.yugyd.viewmodeldelegates.ViewModelLogger

internal class ContentViewModelFactory(
    private val arguments: ContentArguments,
    private val logger: Logger,
    private val dispatchersProvider: DispatchersProvider,
    private val viewModelLogger: ViewModelLogger,
    private val repository: ContentRepository,
) : BaseViewModelFactory {

    override fun create(autoInit: Boolean): ContentViewModel {
        return ContentViewModelImpl(
            initialState = State(arguments = arguments),
            dispatchersProvider = dispatchersProvider,
            logger = logger,
            viewModelLogger = viewModelLogger,
            repository = repository,
        ).apply {
            if (autoInit) {
                init()
            }
        }
    }
}
