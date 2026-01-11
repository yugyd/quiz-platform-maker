plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKmpLibrary)
    alias(libs.plugins.androidLint)
}

kotlin {
    android {
        namespace = "com.yugyd.quizmaker.core.logger"
        compileSdk = 36
        minSdk = 24
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain {
            dependencies {
                api(project(":product:core:logger-api"))

                // Kotlin
                implementation(libs.kotlin.stdlib)

                // Logger
                implementation(libs.napier)
            }
        }
    }
}