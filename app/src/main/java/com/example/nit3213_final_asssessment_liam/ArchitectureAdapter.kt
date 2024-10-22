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
        val tvAtrchitectureArchitect: TextView = itemView.findViewById(R.id.tv_ArchitectureArchitect)
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
        val Architecture = architectureList[position]
        holder.tvArchitectureName.text = Architecture.tv_ArchitectureName
        holder.tvAtrchitectureArchitect.text = Architecture.tv_ArchitectureArchitect
        holder.tvArchitectureLocation.text = Architecture.tv_ArchitectureLocation
        holder.tvArchitectureYearCompleted.text = "Year Completed: ${Architecture.tv_ArchitectureYearCompleted}"
        holder.tvArchitectureStyle.text = Architecture.tv_ArchitectureStyle
        holder.tvArchitectureHeight.text = "Architecture Height: ${Architecture.tv_ArchitectureHeight}"
        holder.tvArchitectureDescription.text = Architecture.tv_ArchitectureDescription


        holder.btnSeeDetail.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ArchitectureDetailActivity::class.java).apply {
                putExtra("architectureName",Architecture.tv_ArchitectureName)
                putExtra("playerCount", Architecture.tv_ArchitectureArchitect)
                putExtra("fieldType",Architecture.tv_ArchitectureLocation)
                putExtra("olympicSport",Architecture.tv_ArchitectureYearCompleted)
                putExtra("olympicSport",Architecture.tv_ArchitectureStyle)
                putExtra("olympicSport",Architecture.tv_ArchitectureHeight)
                putExtra("ARCHITECTURE_DESCRIPTION", Architecture.tv_ArchitectureDescription)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return architectureList.size
    }
}