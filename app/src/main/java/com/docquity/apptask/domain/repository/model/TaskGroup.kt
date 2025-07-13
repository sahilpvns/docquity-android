package com.docquity.apptask.domain.repository.model


data class TaskGroup(
    val category: String,
    val progress: Int,
    val task_count: Int,
    val color1: String,
    val color2: String,
)
