package com.docquity.apptask.servies

import com.docquity.apptask.model.InProgress
import com.docquity.apptask.model.TaskGroup
import com.docquity.apptask.model.UserInfo
import retrofit2.http.GET

interface UsersService {

    @GET("users")
    suspend fun getUsers(): UserInfo

    @GET("progress")
    suspend fun getInProgress(): List<InProgress>

    @GET("task_group")
    suspend fun getTaskGroup(): List<TaskGroup>

}
