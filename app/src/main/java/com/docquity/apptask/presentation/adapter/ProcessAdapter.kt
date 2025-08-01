package com.docquity.apptask.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.RecyclerView
import com.docquity.apptask.databinding.ItemProcessBinding
import com.docquity.apptask.domain.repository.model.ProcessInfoItem

class ProcessAdapter(private val processList: List<ProcessInfoItem>) : RecyclerView.Adapter<ProcessAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemProcessBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val process = processList[position]
        holder.bind(process)
    }

    override fun getItemCount(): Int = processList.size

    class ViewHolder(var binding: ItemProcessBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(process: ProcessInfoItem) {
            binding.apply {
                tvTaskTitle.text = process.category
                tvTaskSubTitle.text = process.title
                sbProcess.progress = process.progress
                cvCard.setCardBackgroundColor(process.color1.toColorInt())
                sbProcess.setIndicatorColor(process.color2.toColorInt())
            }
        }
    }
}