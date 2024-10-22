package com.example.finalassigment.network


import android.telecom.Call
import com.example.nit3213_final_asssessment_liam.data.ArchitectureResponse
import retrofit2.http.GET

interface ArchitectureApi {
    @GET("dashboard/sports")
    fun getArchitecture(): Call<ArchitectureResponse>

}