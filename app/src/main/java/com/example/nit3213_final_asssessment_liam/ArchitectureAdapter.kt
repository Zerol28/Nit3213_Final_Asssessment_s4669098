package com.example.nit3213_final_asssessment_liam

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nit3213_final_asssessment_liam.data.Architecture

class ArchitectureAdapter(private val architectureList: List<Architecture>) : RecyclerView.Adapter<ArchitectureAdapter.ArchitectureViewHolder>() {

    class ArchitectureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvArchitectureName: TextView = itemView.findViewById(R.id.tv_ArchitectureName)
        val tvArchitectureArchitect: TextView = itemView.findViewById(R.id.tv_ArchitectureArchitect)
        val tvArchitectureLocation: TextView = itemView.findViewById(R.id.tv_ArchitectureLocation)
        val tvArchitectureYearCompleted: TextView = itemView.findViewById(R.id.tv_ArchitectureYearCompleted)
        val tvArchitectureStyle: TextView = itemView.findViewById(R.id.tv_ArchitectureStyle)
        val tvArchitectureHeight: TextView = itemView.findViewById(R.id.tv_ArchitectureHeight)
        val tvArchitectureDescription: TextView = itemView.findViewById(R.id.tv_ArchitectureDescription)
        val btnSeeDetail: Button = itemView.findViewById(R.id.btnSeeDetail)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArchitectureViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_architecture, parent, false)
        return ArchitectureViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArchitectureViewHolder, position: Int) {
        val architecture = architectureList[position]
        holder.tvArchitectureName.text = architecture.name
        "architect: ${architecture.architect}".also { holder.tvArchitectureArchitect.text = it }
        "location: ${architecture.location}".also { holder.tvArchitectureLocation.text = it }
        "Year Completed: ${architecture.yearCompleted}".also { holder.tvArchitectureYearCompleted.text = it }
        "style: ${architecture.style}".also { holder.tvArchitectureStyle.text = it }
        "height: ${architecture.height}".also { holder.tvArchitectureHeight.text = it }
        "description: ${architecture.description}".also { holder.tvArchitectureDescription.text = it }


        holder.btnSeeDetail.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ArchitectureDetailActivity::class.java).apply {
                putExtra("name", architecture.name)
                putExtra("architect", architecture.architect)
                putExtra("location",architecture.location)
                putExtra("year completed",architecture.yearCompleted)
                putExtra("style",architecture.style)
                putExtra("height",architecture.height)
                putExtra("description", architecture.description)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return architectureList.size
    }
}