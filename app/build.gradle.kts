plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.nit3213_final_asssessment_liam"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.nit3213_final_asssessment_liam"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx) // Core Kotlin extensions for Android
    implementation(libs.androidx.appcompat) // AndroidX AppCompat library for backward compatibility
    implementation(libs.material) // Material Components for Android
    implementation(libs.androidx.activity) // Activity library for Android
    implementation(libs.androidx.constraintlayout) // Constraint layout for flexible UI designs

    // Retrofit dependencies
    implementation(libs.retrofit) // Retrofit library for networking
    implementation(libs.converter.moshi) // Moshi converter for Retrofit
    implementation(libs.moshi.kotlin) // Moshi Kotlin support
    implementation(libs.logging.interceptor) // Logging interceptor for HTTP requests
    implementation(libs.converter.gson) // Gson converter for Retrofit
    implementation(libs.gson) // Gson library for JSON serialization/deserialization

    // Hilt dependencies
    implementation(libs.hilt.android) // Hilt for dependency injection in Android
    kapt(libs.hilt.android.compiler) // Hilt annotation processor

    testImplementation(libs.junit) // JUnit for unit testing
    androidTestImplementation(libs.androidx.junit) // JUnit for Android instrumentation testing
    androidTestImplementation(libs.androidx.espresso.core) // Espresso for UI testing

}

// Allow references to generated code
kapt {
    correctErrorTypes = true // Enable correct error types for generated code
}

