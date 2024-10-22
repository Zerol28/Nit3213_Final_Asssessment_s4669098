package com.example.nit3213_final_asssessment_liam.data

// Data class representing an architecture entity
data class Architecture(
    val name: String,             // Name of the architecture
    val architect: String,        // Name of the architect
    val location: String,         // Location of the architecture
    val yearCompleted: Int,       // Year the architecture was completed
    val style: String,            // Architectural style
    val height: Int,              // Height of the architecture (in appropriate units)
    val description: String        // Description of the architecture
)
