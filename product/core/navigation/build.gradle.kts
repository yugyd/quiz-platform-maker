plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKmpLibrary)
    alias(libs.plugins.androidLint)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinxSerialization)
}

kotlin {
    android {
        namespace = "com.yugyd.quizmaker.core.navigation"
        compileSdk = 36
        minSdk = 24
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain {
            dependencies {
                api(project(":product:core:navigation-api"))

                // Compose
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.ui)
                implementation(compose.components.resources)

                // Kotlin
                implementation(libs.kotlin.stdlib)

                // Navigation
                implementation(libs.navigation.compose)
                implementation(libs.navigation.adaptive)

                // Serialization
                implementation(libs.kotlinx.serialization.core)
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }
}
