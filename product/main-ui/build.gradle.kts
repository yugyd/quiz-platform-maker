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
        namespace = "com.yugyd.quizmaker.main.ui"
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
            // Compose
            implementation(libs.androidx.activity.compose)

            // DI
            implementation(libs.koin.android)
            implementation(libs.koin.compose)
        }
        commonMain {
            dependencies {
                implementation(project(":product:core:navigation"))
                implementation(project(":product:content-ui"))
                implementation(project(":product:core:designsystem-components"))

                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.ui)
                implementation(compose.components.resources)
                implementation(libs.ui.tooling.preview)
                implementation(libs.androidx.lifecycle.viewmodel)
                implementation(libs.androidx.lifecycle.runtimeCompose)

                // DI
                implementation(libs.koin.core)

                // Navigation
                implementation(libs.navigation.compose)
                implementation(libs.navigation.adaptive)
            }
        }
    }
}

dependencies {
    androidRuntimeClasspath(libs.ui.tooling)
}
