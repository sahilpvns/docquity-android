package com.docquity.apptask.servies

import com.docquity.apptask.model.ProcessInfoItem
import com.docquity.apptask.model.TaskGroup
import com.docquity.apptask.model.UserInfo
import retrofit2.http.GET

interface UsersService {

    @GET("user")
    suspend fun getUsers(): UserInfo

    @GET("progress")
    suspend fun getInProgress(): List<ProcessInfoItem>

    @GET("task_group")
    suspend fun getTaskGroup(): List<TaskGroup>

}
