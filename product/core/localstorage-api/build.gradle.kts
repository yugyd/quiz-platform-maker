plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKmpLibrary)
    alias(libs.plugins.androidLint)
}

kotlin {
    android {
        namespace = "com.yugyd.quizmaker.core.localstorage.api"
        compileSdk = 36
        minSdk = 24
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain {
            dependencies {
                // Kotlin
                implementation(libs.kotlin.stdlib)

                // Threading
                implementation(libs.coroutines.core)
            }
        }
    }
}
