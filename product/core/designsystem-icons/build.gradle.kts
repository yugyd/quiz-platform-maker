import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKmpLibrary)
    alias(libs.plugins.androidLint)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    androidLibrary {
        namespace = "com.yugyd.quizmaker.designsystem.icons"
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
        commonMain {
            dependencies {
                // Compose
                implementation(compose.runtime)
                implementation(compose.components.resources)

                // Kotlin
                implementation(libs.kotlin.stdlib)
            }
        }
    }
}

compose {
    resources {
        publicResClass = true
    }
}
