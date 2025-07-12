package com.docquity.apptask.repository

import com.docquity.apptask.model.InProgress
import com.docquity.apptask.model.TaskGroup
import com.docquity.apptask.model.UserInfo
import com.docquity.apptask.network.NetworkClient


class Repository {
    private val userService = NetworkClient.apiService

    // Fetch posts from the API
    suspend fun getUser(): UserInfo {
        return userService.getUsers()
    }

    suspend fun getProgress(): List<InProgress>{
        return userService.getInProgress()
    }

    suspend fun getCompleted(): List<TaskGroup>{
        return userService.getTaskGroup()
    }

}