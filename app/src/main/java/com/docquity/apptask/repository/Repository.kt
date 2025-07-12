package com.docquity.apptask.repository

import com.docquity.apptask.model.ProcessInfoItem
import com.docquity.apptask.model.TaskGroup
import com.docquity.apptask.model.UserInfo
import com.docquity.apptask.network.NetworkClient


class Repository {
    private val userService = NetworkClient.apiService

    // Fetch posts from the API
    suspend fun getUser(): UserInfo {
        return userService.getUsers()
    }

    suspend fun getProgress(): List<ProcessInfoItem> {
        return userService.getInProgress()
    }

    suspend fun getTaskGroup(): List<TaskGroup> {
        return userService.getTaskGroup()
    }

}