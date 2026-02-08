import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLint)
}

kotlin {
    jvm {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain {
            dependencies {
                // Mvvm
                api(libs.viewmodeldelegates)

                // Kotlin
                implementation(libs.kotlin.stdlib)

                // View model delegates
                api(libs.viewmodeldelegates)
            }
        }
    }
}
