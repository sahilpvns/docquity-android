package com.docquity.apptask.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.docquity.apptask.databinding.ItemTaskGroupBinding
import com.docquity.apptask.model.TaskGroup

class TaskGroupAdapter(private val taskGroupList: List<TaskGroup>) : RecyclerView.Adapter<TaskGroupAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTaskGroupBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val taskGroup = taskGroupList[position]
        holder.bind(taskGroup)
    }

    override fun getItemCount(): Int = taskGroupList.size

    class ViewHolder(var binding: ItemTaskGroupBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(taskGroup: TaskGroup) {
            binding.tvTaskTitle.text = taskGroup.category
            binding.tvTaskSubTitle.text = taskGroup.task_count.toString() + " Tasks"
            binding.progressText.text = taskGroup.progress.toString()
            binding.circularProgress.progress = taskGroup.progress
        }
    }
}