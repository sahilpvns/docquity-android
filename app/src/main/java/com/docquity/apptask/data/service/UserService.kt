package com.docquity.apptask.data.service

import com.docquity.apptask.domain.repository.model.ProcessInfoItem
import com.docquity.apptask.domain.repository.model.TaskGroup
import com.docquity.apptask.domain.repository.model.UserInfo
import retrofit2.http.GET

interface UserService {

    @GET("user")
    suspend fun getUsers(): UserInfo

    @GET("progress")
    suspend fun getInProgress(): List<ProcessInfoItem>

    @GET("task_group")
    suspend fun getTaskGroup(): List<TaskGroup>

}
