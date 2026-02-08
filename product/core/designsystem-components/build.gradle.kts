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
        namespace = "com.yugyd.quizmaker.designsystem.components"
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
        }

        commonMain {
            dependencies {
                implementation(project(":product:core:designsystem-icons"))

                // Compose
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.ui)
                implementation(compose.components.resources)
                implementation(libs.ui.tooling.preview)

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

dependencies {
    androidRuntimeClasspath(libs.ui.tooling)
}
