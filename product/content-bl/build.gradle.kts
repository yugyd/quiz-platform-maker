import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinxSerialization)
}

kotlin {
    jvm {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_11
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":product:core:coroutines"))
                implementation(project(":product:core:localstorage-api"))
                implementation(project(":product:core:logger-api"))
                implementation(project(":product:core:viewmodel-api"))

                // Kotlin
                implementation(libs.kotlin.stdlib)

                // DI
                implementation(libs.koin.core)

                // Database
                implementation(libs.androidx.room.runtime)

                // Serialization
                implementation(libs.kotlinx.serialization.core)
                implementation(libs.kotlinx.serialization.json)

                // Network
                implementation(libs.ktor.client.core)

                // View model delegates
                api(libs.viewmodeldelegates)
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }
}
