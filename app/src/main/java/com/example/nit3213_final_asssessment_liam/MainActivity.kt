package com.example.nit3213_final_asssessment_liam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nit3213_final_asssessment_liam.data.ArchitectureResponse
import com.example.nit3213_final_asssessment_liam.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var architectureAdapter: ArchitectureAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Fetch data from API
        fetchArchitectureData()
    }

    private fun fetchArchitectureData() {
        RetrofitInstance.api.getArchitecture().enqueue(object : Callback<ArchitectureResponse> {
            override fun onResponse(call: Call<ArchitectureResponse>, response: Response<ArchitectureResponse>) {
                if (response.isSuccessful) {
                    val architectureList = response.body()?.entities
                    architectureList?.let {
                        // Set up the adapter with the retrieved data
                        architectureAdapter = ArchitectureAdapter(it)
                        recyclerView.adapter = architectureAdapter
                    }
                }
            }

            override fun onFailure(call: Call<ArchitectureResponse>, t: Throwable) {
                // Handle error
            }
        })
    }
}