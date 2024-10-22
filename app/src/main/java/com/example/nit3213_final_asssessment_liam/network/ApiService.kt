package com.example.nit3213_final_asssessment_liam.network

import com.example.nit3213_final_asssessment_liam.data.ArchitectureResponse // Import ArchitectureResponse data model
import retrofit2.http.GET // Import GET annotation for defining GET requests
import retrofit2.Call // Import Call interface for Retrofit network calls


// Interface defining the API for fetching architecture data
interface ArchitectureApi {

    // HTTP GET request to fetch architecture data from the specified endpoint
    @GET("dashboard/architecture")
    fun getArchitecture(): Call<ArchitectureResponse> // Returns a Call object for the architecture response

}
