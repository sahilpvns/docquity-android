package com.docquity.apptask.repository

import com.docquity.apptask.model.ProcessInfoItem
import com.docquity.apptask.model.TaskGroup
import com.docquity.apptask.model.UserInfo
import com.docquity.apptask.servies.UsersService
import javax.inject.Inject


class Repository @Inject constructor(private val userService: UsersService) {
    suspend fun getUser(): UserInfo = userService.getUsers()
    suspend fun getProgress(): List<ProcessInfoItem> = userService.getInProgress()
    suspend fun getTaskGroup(): List<TaskGroup> = userService.getTaskGroup()
}