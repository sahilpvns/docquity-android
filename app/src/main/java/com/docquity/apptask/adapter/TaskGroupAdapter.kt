package com.docquity.apptask.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.docquity.apptask.databinding.ItemTaskGroupBinding

class TaskGroupAdapter() : RecyclerView.Adapter<TaskGroupAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTaskGroupBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        /*  val taskGroup = taskGroupList[position]
          holder.bind(taskGroup)*/
    }

    override fun getItemCount(): Int = 10

    class ViewHolder(var binding: ItemTaskGroupBinding) : RecyclerView.ViewHolder(binding.root) {
    }
}