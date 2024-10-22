package com.example.nit3213_final_asssessment_liam.data

// Data class representing the response from the architecture API
data class ArchitectureResponse(
    val entities: List<Architecture>, // List of architecture entities returned from the API
    val entityTotal: Int              // Total number of architecture entities in the response
)
