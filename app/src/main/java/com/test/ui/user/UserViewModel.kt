package com.test.ui.user

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.domain.UsersRepository
import com.test.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val usersRepository: UsersRepository
): ViewModel() {

    var user: User? by mutableStateOf(null)
        private set

    fun initUser(userUuid: String) {
        viewModelScope.launch {
            user = usersRepository.getUser(userUuid)
        }
    }
}