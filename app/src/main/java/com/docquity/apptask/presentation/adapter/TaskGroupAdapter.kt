package com.docquity.apptask.presentation.adapter

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.RecyclerView
import com.docquity.apptask.databinding.ItemTaskGroupBinding
import com.docquity.apptask.domain.repository.model.TaskGroup

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
            binding.apply {
                tvTaskTitle.text = taskGroup.category
                tvTaskSubTitle.text = taskGroup.task_count.toString() + " Tasks"
                progressText.text = taskGroup.progress.toString() + "%"
                circularProgress.progress = taskGroup.progress
                circularProgress.setIndicatorColor(taskGroup.color1.toColorInt())
                ivItemLogo.backgroundTintList = ColorStateList.valueOf(taskGroup.color1.toColorInt())
            }
        }
    }
}