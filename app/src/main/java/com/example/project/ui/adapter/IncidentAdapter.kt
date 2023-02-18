package com.example.project.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.project.data.IncidentDto
import com.example.project.databinding.ItemBinding

class IncidentAdapter(val onClick: (Int) -> Unit) :
    ListAdapter<IncidentDto, IncidentAdapter.Holder>(DiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding.category.text = getItem(position).description
        holder.binding.category.setOnClickListener {
            onClick(getItem(position).id)
        }
    }

    class Holder(
        val binding: ItemBinding
    ) : RecyclerView.ViewHolder(binding.root)

    class DiffUtilCallback : DiffUtil.ItemCallback<IncidentDto>() {
        override fun areItemsTheSame(oldItem: IncidentDto, newItem: IncidentDto): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: IncidentDto, newItem: IncidentDto): Boolean {
            return oldItem == newItem
        }
    }
}

