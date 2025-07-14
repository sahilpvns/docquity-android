package com.docquity.apptask.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.docquity.apptask.domain.repository.Repository
import com.docquity.apptask.domain.repository.model.ProcessInfoItem
import com.docquity.apptask.domain.repository.model.TaskGroup
import com.docquity.apptask.domain.repository.model.UserInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserVM @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _error = MutableLiveData<String>()
    val vmError: LiveData<String> = _error

    private val _vmUser = MutableLiveData<UserInfo>()
    val vmUser: LiveData<UserInfo> = _vmUser

    private val _vmProcess = MutableLiveData<List<ProcessInfoItem>>()
    val vmProcess: LiveData<List<ProcessInfoItem>> = _vmProcess

    private val _vmTaskGroup = MutableLiveData<List<TaskGroup>>()
    val vmTaskGroup: LiveData<List<TaskGroup>> = _vmTaskGroup

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun loadAllData() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _vmUser.value = repository.getUser()
                _vmProcess.value = repository.getProgress()
                _vmTaskGroup.value = repository.getTaskGroup()
            } catch (e: Exception) {
                _error.value = e.message ?: "Something went wrong"
            } finally {
                _isLoading.value = false
            }
        }
    }
}