plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    jvm("desktop")
}

android {
    namespace = "com.tigeryan.mvi"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
}