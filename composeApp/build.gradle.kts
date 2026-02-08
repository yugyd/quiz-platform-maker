import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKmpLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    androidLibrary {
        namespace = "com.yugyd.quizmaker.composeapp"

        compileSdk = 36
        minSdk = 24

        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)

            // DI
            implementation(libs.koin.android)
        }
        commonMain.dependencies {
            implementation(project(":product:core:logger"))
            implementation(project(":product:core:localstorage"))
            implementation(project(":product:core:database"))
            implementation(project(":product:core:coroutines"))
            implementation(project(":product:core:navigation"))
            implementation(project(":product:main-ui"))

            // Navigation
            implementation(libs.navigation.compose)

            // Kotlin
            implementation(libs.kotlin.stdlib)

            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(libs.ui.tooling.preview)

            // DI
            implementation(libs.koin.core)
        }
        iosMain.dependencies {
            // DI
            implementation(libs.koin.core)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

dependencies {
    androidRuntimeClasspath(libs.ui.tooling)
}
