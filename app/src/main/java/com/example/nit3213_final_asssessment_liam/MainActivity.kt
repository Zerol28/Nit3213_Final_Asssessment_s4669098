package com.example.nit3213_final_asssessment_liam

import android.os.Bundle // Import Bundle class for activity state
import androidx.appcompat.app.AppCompatActivity // Import AppCompatActivity for compatibility with older Android versions
import androidx.recyclerview.widget.LinearLayoutManager // Import LinearLayoutManager for RecyclerView
import androidx.recyclerview.widget.RecyclerView // Import RecyclerView for displaying lists
import com.example.nit3213_final_asssessment_liam.data.ArchitectureResponse // Import ArchitectureResponse data model
import com.example.nit3213_final_asssessment_liam.network.RetrofitInstance // Import Retrofit instance for network calls
import retrofit2.Call // Import Call interface for Retrofit network calls
import retrofit2.Callback // Import Callback interface for handling responses
import retrofit2.Response // Import Response class for handling API responses


class MainActivity : AppCompatActivity() {

    // Declare RecyclerView to display data in a list
    private lateinit var recyclerView: RecyclerView

    // Declare Adapter to bind data to RecyclerView
    private lateinit var architectureAdapter: ArchitectureAdapter

    // onCreate is called when the activity is first created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the content view to the layout resource activity_main
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView by finding it from the layout (activity_main.xml)
        recyclerView = findViewById(R.id.recyclerView)

        // Set the layout manager for the RecyclerView to LinearLayoutManager
        // This ensures that the items are displayed in a linear, vertical list
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Fetch data from the API to populate the RecyclerView
        fetchArchitectureData()
    }

    // Function to fetch architectural data from the API using Retrofit
    private fun fetchArchitectureData() {
        // Call the API using Retrofit instance and enqueue the request for asynchronous execution
        RetrofitInstance.api.getArchitecture().enqueue(object : Callback<ArchitectureResponse> {

            // This function is called when a response is received from the API
            override fun onResponse(call: Call<ArchitectureResponse>, response: Response<ArchitectureResponse>) {
                // Check if the response was successful
                if (response.isSuccessful) {
                    // Retrieve the list of architecture entities from the API response body
                    val architectureList = response.body()?.entities

                    // If the architectureList is not null, proceed with setting up the adapter
                    architectureList?.let {
                        // Initialize the adapter with the data (architectureList)
                        architectureAdapter = ArchitectureAdapter(it)

                        // Set the adapter to the RecyclerView to display the list of architectures
                        recyclerView.adapter = architectureAdapter
                    }
                }
            }

            // This function is called if the API request fails (e.g., network error)
            override fun onFailure(call: Call<ArchitectureResponse>, t: Throwable) {
                // Handle the error scenario, like showing a message to the user
                // For now, this block is left empty and can be customized as needed
            }
        })
    }
}
