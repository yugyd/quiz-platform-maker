package com.yugyd.quizmaker.core.viewmodel.api

import com.yugyd.viewmodeldelegates.ViewModel

interface BaseViewModelFactory {
    fun create(autoInit: Boolean = true): ViewModel<*, *>
}
