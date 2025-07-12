package com.docquity.apptask.model

data class InProgress(
    val in_progress: InProgress_?
)

data class InProgress_(
    val count: Int,
    val projects: List<Project>
)

data class Project(
    val category: String,
    val title: String
)

