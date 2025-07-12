package com.docquity.apptask.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.docquity.apptask.databinding.ItemProcessBinding

class ProcessAdapter() : RecyclerView.Adapter<ProcessAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemProcessBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int = 10

    class ViewHolder(var binding: ItemProcessBinding) : RecyclerView.ViewHolder(binding.root) {
    }
}