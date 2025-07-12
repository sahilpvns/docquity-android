package com.docquity.apptask.model

data class TaskGroup(
    val task_groups: TaskGroups
)

data class TaskGroups(
    val count: Int,
    val groups: List<Group>
)

data class Group(
    val category: String,
    val progress: Int,
    val task_count: Int
)

