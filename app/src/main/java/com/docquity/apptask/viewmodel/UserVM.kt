package com.docquity.apptask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.docquity.apptask.model.ProcessInfoItem
import com.docquity.apptask.model.TaskGroup
import com.docquity.apptask.model.UserInfo
import com.docquity.apptask.repository.Repository
import kotlinx.coroutines.launch

class UserVM : ViewModel() {
    private val repository = Repository()
    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _vmUser = MutableLiveData<UserInfo>()
    val vmUser: LiveData<UserInfo> = _vmUser

    fun getUserInfo() {
        viewModelScope.launch {
            try {
                _vmUser.value = repository.getUser()
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }

    private val _vmProcess = MutableLiveData<List<ProcessInfoItem>>()
    val vmProcess: LiveData<List<ProcessInfoItem>> = _vmProcess

    fun getProcess() {
        viewModelScope.launch {
            try {
                if (repository.getProgress().isNotEmpty()) {
                    _vmProcess.value = repository.getProgress()
                } else {
                    _error.value = "No Data Found"
                }
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }

    private val _vmTaskGroup = MutableLiveData<List<TaskGroup>>()
    val vmTaskGroup: LiveData<List<TaskGroup>> = _vmTaskGroup

    fun getTaskGroup() {
        viewModelScope.launch {
            try {
                if (repository.getTaskGroup().isNotEmpty()) {
                    _vmTaskGroup.value = repository.getTaskGroup()
                } else {
                    _error.value = "No Data Found"
                }
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }

}