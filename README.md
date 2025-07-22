Quiz Maker
==========

KMP project for Android and iOS. Adding and editing content for the Quiz-Platform client application.

# Download Quiz Maker

Coming soon app "Quiz Maker" on Google Play.

# Stack

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

# Build types

The debug build option can be built and run. The release option is used on internal projects and
is not publicly available, you need a real Firebase project to access it.

Debug - Logging, debug mode, proguard off.

Release - No logging, no debug mode, proguard enabled.

# Build

## Android

#### Build debug

- `./gradlew clean assembleDebug`

#### Upload to Google Play

- `./gradlew clean bundleRelease`
- Manual upload to Google Play

## iOS

Coming soon.

# License

```
   Copyright 2025 Roman Likhachev

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
