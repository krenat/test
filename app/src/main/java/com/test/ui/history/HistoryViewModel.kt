package com.test.ui.history

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
class HistoryViewModel @Inject constructor(
    private val usersRepository: UsersRepository
): ViewModel() {

    var historyUsers: List<User> by mutableStateOf(emptyList())
        private set

    init {
        getHistory()
    }

    private fun getHistory() {
        viewModelScope.launch {
            historyUsers = usersRepository.getStoredUsers()
        }
    }
}