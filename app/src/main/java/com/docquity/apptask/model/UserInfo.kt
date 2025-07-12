package com.docquity.apptask.model

data class UserInfo(
    val user: User
)

data class User(
        val action: String,
        val completion_status: String,
        val greeting: String,
        val name: String,
        val profile_url: String,
        val progress: Int,
    )
