import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKmpLibrary)
    alias(libs.plugins.androidLint)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinxSerialization)
}

kotlin {
    androidLibrary {
        namespace = "com.yugyd.quizmaker.content.ui"
        compileSdk = 36
        minSdk = 24

        androidResources.enable = true

        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        androidMain.dependencies {
            implementation(libs.ui.tooling.preview)
            implementation(libs.androidx.activity.compose)
        }
        commonMain {
            dependencies {
                implementation(project(":product:content-bl"))
                implementation(project(":product:core:coroutines"))
                implementation(project(":product:core:navigation"))
                implementation(project(":product:core:designsystem-icons"))
                implementation(project(":product:core:designsystem-components"))

                // Compose
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.ui)
                implementation(compose.components.resources)
                implementation(libs.ui.tooling.preview)
                implementation(libs.androidx.lifecycle.viewmodel)
                implementation(libs.androidx.lifecycle.runtimeCompose)

                // Kotlin
                implementation(libs.kotlin.stdlib)

                // DI
                implementation(libs.koin.compose.nav)
                implementation(libs.koin.compose.viewmodel.nav)

                // View model delegates
                implementation(libs.viewmodeldelegates.ui)

                // Navigation
                implementation(libs.navigation.compose)
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }
}

dependencies {
    androidRuntimeClasspath(libs.ui.tooling)
}
