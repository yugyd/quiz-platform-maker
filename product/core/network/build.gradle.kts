import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKmpLibrary)
    alias(libs.plugins.androidLint)
}

kotlin {
    androidLibrary {
        namespace = "com.yugyd.core.network"
        compileSdk = 36
        minSdk = 24

        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        androidMain {
            dependencies {
                // Network
                api(libs.ktor.client.okhttp)
            }
        }

        commonMain {
            dependencies {
                api(project(":product:core:network-api"))

                implementation(project(":product:core:logger-api"))

                // Kotlin
                implementation(libs.kotlin.stdlib)

                // Threading
                api(libs.coroutines.core)

                // Network
                api(libs.ktor.client.core)
                api(libs.ktor.client.content.negotiation)
                api(libs.ktor.client.logging)
                api(libs.ktor.serialization.kotlinx.json)
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        iosMain {
            dependencies {
                // Network
                api(libs.ktor.client.darwin)
            }
        }
    }
}
