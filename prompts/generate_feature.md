# Generate a Jetpack Compose screen in Kotlin strictly following the given architecture and templates

* Task: Generate a screen using Jetpack Compose in Kotlin. The architecture must strictly follow the
  template. Entities must strictly follow templates, such as LocalStorage. The main CRUD scenarios
  are described in the domain layer templates, particularly Repository. Use ready-made CRUD
  scenarios.
* Context: tag_ai_code_generator:screen_description
* Input:
    * Text UI specification (ui semantics)
    * Description of screen logic
    * Tech stack
    * Database Core module
    * Templates: ViewModelDelegates architecture, CRUD scenarios and sample feature implementation
* Requirements:
    * Use Material 3 components.
    * The code must be self-contained and can be inserted into the project.
    * Prefer Material 3 components. If an exact equivalent is not available, use the basic
      Row/Box layout.
    * Colors and typography: only via `MaterialTheme`.
    * Icons: do not recreate vector descriptions manually. I'll add the icons myself, just give them
      the names yourself.
    * Strings: via stringResource.
    * Preview: wrap in `QuizMakerTheme`, show separated enabled/disabled.
    * Actions (tap, click) are handled via lambdas in parameters; the viewModel is not passed down
      the deep hierarchy, only at the entry point.
    * ViewModel requirements:
        * Use ViewModel delegates library, do the same according to the templates.
        * Use a data class for the single state class. Use the UiModel suffix for the state class.
    * Do not use TODO(), error(), or placeholder implementations.
    * Do not introduce new architectural concepts.
    * Use tech stack from the project. But Tech stack is declarative:
        * Use technologies from the stack ONLY if they are required by the ui or screen logic.
        * Do not introduce usage solely because a library is listed.
* Acceptance Criteria:
    * The code compiles without hard-coding colors and strings where the Material 3 components can
      be used.
    * Material 3 components/tokens are used.
    * Preview with `MaterialTheme` is available.
    * The ViewModel Delegates architecture is used. See the architecture and templates below.
    * Output:
        * Kotlin files
        * No explanations, only code
        * All files are split into two modules, bl and ui, according to templates.
        * Packages are split strictly according to templates.
        * Entity suffixes strictly follow templates. For example: `...LocalStorage`,
          `...InMemoryStorage`, etc. If the entity does not match the one defined in the template,
          you can specify the name yourself.
        * The set of files is limited only to the necessary minimum according to templates and
          feature requirements.
* Input data:
    * [Text UI specification](#text-ui-specification)
    * [Description of screen logic](#description-of-screen-logic)
    * [Tech stack](#tech-stack)
    * [Database Core module](#database-core-module)
    * [Templates: ViewModelDelegates architecture, CRUD scenarios and sample feature implementation](#templates-viewmodel-delegates-architecture-crud-scenarios-and-sample-feature-implementation)

# Text UI specification

tag_ai_code_generator:ui_semantics

# Description of screen logic

tag_ai_code_generator:logic_description

# Tech stack

```markdown
The project is developed strictly within the framework of the Kotlin and Google way.

* Min SDK: iOS 15, Android: 10.0
* Language: Kotlin, Swift (for specific data layer on iOS)
* Architecture: MVVM (JVM MVVM), clean, multi-module
* UI:
    * [Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform)
    * [Material 3](https://kotlinlang.org/api/compose-multiplatform/material3)
    * [MD5 Render](https://github.com/mikepenz/multiplatform-markdown-renderer)
* Navigation:
    * [Jetpack Compose Navigation: Kotlin Multiplatform Beta](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-navigation.html#basic-navigation-example)
* Threading:
    * [Coroutines and Flow](https://github.com/Kotlin/kotlinx.coroutines)
    * [Swift Concurrency (async/await): Only iOS](https://developer.apple.com/documentation/swift/concurrency)
* Database:
    * [Room Kotlin Multiplatform](https://developer.android.com/kotlin/multiplatform/room)
* Local storage:
    * [DataStore (Kotlin Multiplatform)](https://developer.android.com/kotlin/multiplatform/datastore)
    * [Okio](https://github.com/square/okio)
* Network: [Ktor (client)](https://github.com/ktorio/ktor)
* Serialization: [kotlinx-serialization](https://github.com/Kotlin/kotlinx.serialization)
* DI: [Koin](https://github.com/InsertKoinIO/koin)
* Image: [Coil](https://github.com/coil-kt/coil)
* Mobile Services: Analytics, AppIndexing, Crashlytics, Cloud Messaging, Remote Config
    * [Firebase Kotlin SDK](https://github.com/gitliveapp/firebase-kotlin-sdk/)
* Date and Time: [kotlinx-datetime](https://github.com/Kotlin/kotlinx-datetime)
* Logging: [Napier](https://github.com/AAkira/Napier)
* Testing: [Mockk](https://github.com/mockk/mockk), JUnit
* Animation: [Kottie](https://github.com/ismai117/kottie)
```

# Database Core module

```
tag_ai_code_generator:database_module_files
```

# Templates: ViewModel Delegates architecture, CRUD scenarios and sample feature implementation

## BL module

```
tag_ai_code_generator:bl_module_files
```

## UI module

```
tag_ai_code_generator:ui_module_files
```
