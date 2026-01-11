package com.yugyd.quizmaker.core.coroutines

import kotlinx.coroutines.CoroutineDispatcher

/**
 * Provides coroutine dispatchers for different types of operations. This interface allows for easy
 * swapping of dispatchers, which is useful for testing.
 *
 * @property io Dispatcher for IO-bound operations, such as database or network access.
 * @property default Dispatcher for CPU-bound operations.
 * @property main Dispatcher for operations that need to run on the main thread, such as UI.
 * Immediate variant.
 */
interface DispatchersProvider {
    val io: CoroutineDispatcher
    val default: CoroutineDispatcher
    val main: CoroutineDispatcher
}
