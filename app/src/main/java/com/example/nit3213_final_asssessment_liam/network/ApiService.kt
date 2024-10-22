package com.example.nit3213_final_asssessment_liam.network


import com.example.nit3213_final_asssessment_liam.data.Architecture
import com.example.nit3213_final_asssessment_liam.data.ArchitectureResponse
import retrofit2.http.GET
import retrofit2.Call


interface ArchitectureApi {
    @GET("dashboard/architecture")
    fun getArchitecture(): Call<ArchitectureResponse>

}