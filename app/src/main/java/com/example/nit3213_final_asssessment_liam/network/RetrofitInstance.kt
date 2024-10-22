package com.example.nit3213_final_asssessment_liam.network

import retrofit2.Retrofit // Import Retrofit class for making network requests
import retrofit2.converter.gson.GsonConverterFactory // Import GsonConverterFactory for converting JSON data to Kotlin objects


// Singleton object to provide a Retrofit instance for making network requests
object RetrofitInstance {

    // Lazily initialize the Retrofit instance
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://nit3213-api-h2b3-latest.onrender.com/") // Base URL for the API
            .addConverterFactory(GsonConverterFactory.create()) // Converter for JSON serialization and deserialization
            .build() // Build the Retrofit instance
    }

    // Lazily initialize the API service for making requests
    val api: ArchitectureApi by lazy {
        retrofit.create(ArchitectureApi::class.java) // Create an implementation of the API interface
    }
}
