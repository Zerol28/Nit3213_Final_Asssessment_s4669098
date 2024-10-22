package com.example.nit3213_final_asssessment_liam

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class ArchitectureDetailActivity : AppCompatActivity() {

    // Declare TextViews for displaying architecture details
    private lateinit var ArchitectureName: TextView
    private lateinit var ArchitectureArchitect: TextView
    private lateinit var ArchitectureLocation: TextView
    private lateinit var ArchitectureYearCompleted: TextView
    private lateinit var ArchitectureStyle: TextView
    private lateinit var ArchitectureHeight: TextView
    private lateinit var ArchitectureDescription: TextView

    // onCreate is called when the activity is first created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the content view to the layout activity_architecture_detail.xml
        setContentView(R.layout.activity_architecture_detail)

        // Initialize the TextViews by finding them from the layout
        ArchitectureName = findViewById(R.id.tv_ArchitectureName)
        ArchitectureArchitect = findViewById(R.id.tv_ArchitectureArchitect)
        ArchitectureLocation = findViewById(R.id.tv_ArchitectureLocation)
        ArchitectureYearCompleted = findViewById(R.id.tv_ArchitectureYearCompleted)
        ArchitectureStyle = findViewById(R.id.tv_ArchitectureStyle)
        ArchitectureHeight = findViewById(R.id.tv_ArchitectureHeight)
        ArchitectureDescription = findViewById(R.id.tv_ArchitectureDescription)

        // Retrieve data passed through the intent and set default values if null
        val IV_ArchitectureName = intent.getStringExtra("name") ?: "Architecture" // Default to "Architecture" if no data
        val IV_ArchitectureArchitect = intent.getStringExtra("architect") ?: "Unknown" // Default to "Unknown" if no data
        val IV_ArchitectureLocation = intent.getStringExtra("location") ?: "Unknown" // Default to "Unknown" if no data
        val IV_ArchitectureYearCompleted = intent.getIntExtra("year completed", 0) // Default to 0 if no data
        val IV_ArchitectureStyle = intent.getStringExtra("style") ?: "Unknown" // Default to "Unknown" if no data
        val IV_ArchitectureHeight = intent.getIntExtra("height", 0) // Default to 0 if no data
        val IV_ArchitectureDescription = intent.getStringExtra("description") ?: "No description available" // Default description if no data

        // Set the retrieved data to the corresponding TextViews for display
        ArchitectureName.text = "$IV_ArchitectureName"
        ArchitectureArchitect.text = "Architect: $IV_ArchitectureArchitect"
        ArchitectureLocation.text = "Location: $IV_ArchitectureLocation"
        ArchitectureYearCompleted.text = "Year Completed: $IV_ArchitectureYearCompleted"
        ArchitectureStyle.text = "Style: $IV_ArchitectureStyle"
        ArchitectureHeight.text = "Height: $IV_ArchitectureHeight"
        ArchitectureDescription.text = "Description: $IV_ArchitectureDescription"
    }

    // Function to return to the previous activity (dashboard) when a button is clicked
    fun goBackToDashboard(view: View) {
        finish() // Close the current activity and return to the previous one
    }
}
