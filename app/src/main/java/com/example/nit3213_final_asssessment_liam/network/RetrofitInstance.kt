package com.example.nit3213_final_asssessment_liam.network

import com.example.finalassigment.network.ArchitectureApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://nit3213-api-h2b3-latest.onrender.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ArchitectureApi by lazy {
        retrofit.create(ArchitectureApi::class.java)
    }
}