rootProject.name = "QuizMaker"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

include(":composeApp")
include(":androidApp")
// Core
include(":product:core:logger")
include(":product:core:logger-api")
include(":product:core:localstorage-api")
include(":product:core:localstorage")
include(":product:core:coroutines")
include(":product:core:database-api")
include(":product:core:database")
include(":product:core:navigation")
include(":product:core:navigation-api")
include(":product:main-ui")
