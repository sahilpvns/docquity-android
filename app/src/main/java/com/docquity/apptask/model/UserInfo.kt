package com.docquity.apptask.model

data class UserInfo(
    val today_task: TodayTask,
    val user: User
) {
    data class TodayTask(
        val action: String,
        val completion_status: String,
        val progress: Int,
        val title: String
    )

    data class User(
        val greeting: String,
        val name: String
    )
}