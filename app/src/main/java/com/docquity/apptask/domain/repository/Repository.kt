package com.docquity.apptask.domain.repository

import com.docquity.apptask.domain.repository.model.ProcessInfoItem
import com.docquity.apptask.domain.repository.model.TaskGroup
import com.docquity.apptask.domain.repository.model.UserInfo
import com.docquity.apptask.data.service.UserService
import javax.inject.Inject


class Repository @Inject constructor(private val userService: UserService) {
    suspend fun getUser(): UserInfo = userService.getUsers()
    suspend fun getProgress(): List<ProcessInfoItem> = userService.getInProgress()
    suspend fun getTaskGroup(): List<TaskGroup> = userService.getTaskGroup()
}