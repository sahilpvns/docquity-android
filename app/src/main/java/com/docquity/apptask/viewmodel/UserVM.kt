package com.docquity.apptask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

}