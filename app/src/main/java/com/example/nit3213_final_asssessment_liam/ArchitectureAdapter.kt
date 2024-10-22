package com.example.nit3213_final_asssessment_liam

import android.content.Intent // Import Intent class for starting new activities
import android.view.LayoutInflater // Import LayoutInflater class for inflating views
import android.view.View // Import View class for handling UI elements
import android.view.ViewGroup // Import ViewGroup class for handling a group of views
import android.widget.Button // Import Button class for UI buttons
import android.widget.TextView // Import TextView class for displaying text in UI
import androidx.recyclerview.widget.RecyclerView // Import RecyclerView class for displaying lists
import com.example.nit3213_final_asssessment_liam.data.Architecture // Import Architecture data model


// Adapter class for managing and binding architecture data to the RecyclerView
class ArchitectureAdapter(private val architectureList: List<Architecture>) : RecyclerView.Adapter<ArchitectureAdapter.ArchitectureViewHolder>() {

    // ViewHolder class to hold references to the architecture item views
    class ArchitectureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Declare views to be displayed for each architecture
        val tvArchitectureName: TextView = itemView.findViewById(R.id.tv_ArchitectureName)
        //        val tvArchitectureArchitect: TextView = itemView.findViewById(R.id.tv_ArchitectureArchitect)
        val tvArchitectureLocation: TextView = itemView.findViewById(R.id.tv_ArchitectureLocation)
        val tvArchitectureYearCompleted: TextView = itemView.findViewById(R.id.tv_ArchitectureYearCompleted)
        //        val tvArchitectureStyle: TextView = itemView.findViewById(R.id.tv_ArchitectureStyle)
//        val tvArchitectureHeight: TextView = itemView.findViewById(R.id.tv_ArchitectureHeight)
//        val tvArchitectureDescription: TextView = itemView.findViewById(R.id.tv_ArchitectureDescription)
        val btnSeeDetail: Button = itemView.findViewById(R.id.btnSeeDetail) // Button for navigating to the detail view
    }

    // Inflate the layout for each item in the list when ViewHolder is created
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArchitectureViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_architecture, parent, false)
        return ArchitectureViewHolder(view)
    }

    // Bind data to the views in the ViewHolder for each item in the architecture list
    override fun onBindViewHolder(holder: ArchitectureViewHolder, position: Int) {
        val architecture = architectureList[position] // Get the architecture object for the current position

        // Set the name and other relevant details to the TextViews
        holder.tvArchitectureName.text = architecture.name
//        "architect: ${architecture.architect}".also { holder.tvArchitectureArchitect.text = it }
        "location: ${architecture.location}".also { holder.tvArchitectureLocation.text = it }
        "Year Completed: ${architecture.yearCompleted}".also { holder.tvArchitectureYearCompleted.text = it }
//        "style: ${architecture.style}".also { holder.tvArchitectureStyle.text = it }
//        "height: ${architecture.height}".also { holder.tvArchitectureHeight.text = it }
//        "description: ${architecture.description}".also { holder.tvArchitectureDescription.text = it }

        // Set a click listener for the detail button to navigate to ArchitectureDetailActivity
        holder.btnSeeDetail.setOnClickListener {
            val context = holder.itemView.context
            // Create an intent and pass architecture details to the detail activity
            val intent = Intent(context, ArchitectureDetailActivity::class.java).apply {
                putExtra("name", architecture.name)
                putExtra("architect", architecture.architect)
                putExtra("location",architecture.location)
                putExtra("year completed",architecture.yearCompleted)
                putExtra("style",architecture.style)
                putExtra("height",architecture.height)
                putExtra("description", architecture.description)
            }
            // Start the detail activity with the intent
            context.startActivity(intent)
        }
    }

    // Return the total number of items in the architecture list
    override fun getItemCount(): Int {
        return architectureList.size
    }
}
