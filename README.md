# Nit3213 Final Assessment App

## Overview
The Nit3213 Final Assessment App is an Android application designed to provide users with an intuitive interface to interact with architecture-related data. The app allows users to log in, view architectural details, and explore various features seamlessly.

## Features
- **User Authentication**: Secure login functionality to access the app.
- **Architecture Details**: View detailed information about various architectural structures.
- **User-Friendly Interface**: Intuitive design for easy navigation.
- **Networking**: Fetches data from a remote server using Retrofit.
- **Internet Permission**: Requires internet access to retrieve data.

## Requirements
- Android 5.0 (API level 21) or higher
- Internet connection

## Getting Started

### Installation
1. **Clone the repository**:
   ```bash
   git clone https://github.com/Zerol28/Nit3213_Final_Asssessment_s4669098.git

### Opening the project in Android Studio:
1. Launch Android Studio.
2. Click on "Open an existing Android Studio project".
3. Navigate to the cloned repository and select it.

### Configuration
1. Ensure you have the required permissions in the AndroidManifest.xml file.
2. Update any necessary API keys or configurations as needed.

### Dependencies
 - Make sure you have the following dependencies included in your build.gradle file:


### dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Retrofit dependencies
    implementation(libs.retrofit)
    implementation(libs.converter.moshi)
    implementation(libs.moshi.kotlin)
    implementation(libs.logging.interceptor)
    implementation(libs.converter.gson)
    implementation(libs.gson)

    // Hilt dependencies
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

    // Allow references to generated code
    kapt {
        correctErrorTypes = true
    }

