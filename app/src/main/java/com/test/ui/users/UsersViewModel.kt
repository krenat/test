package com.test.ui.users

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.test.R
import com.test.data.network.model.ResultResponse
import com.test.domain.UsersRepository
import com.test.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val usersRepository: UsersRepository
): ViewModel() {

    private var countUsers = 0

    var inputCountUsers by mutableStateOf("")
        private set
    var buttonEnabled by mutableStateOf(countUsers > 0)
        private set
    var users: List<User> by mutableStateOf(emptyList())
        private set
    var error: String by mutableStateOf("")
        private set
    var isLoading: Boolean by mutableStateOf(false)
        private set

    private var navController: NavController? = null

    fun initNavigation(navController: NavController) {
        this.navController = navController
    }

    fun onChangeCountUsers(count: String) {
        count.toIntOrNull()?.let {
            countUsers = it
            inputCountUsers = count
        } ?:run {
            countUsers = 0
            inputCountUsers = ""
        }
        buttonEnabled = countUsers > 0
    }

    fun updateUsers() {
        isLoading = true
        viewModelScope.launch {
            when(val u = usersRepository.getUsers(countUsers)) {
                is ResultResponse.Success -> {
                    isLoading = false
                    error = ""
                    users = u.data
                }
                is ResultResponse.Error -> {
                    isLoading = false
                    error = u.message
                }
            }

            if(users.isNotEmpty()) usersRepository.storeUsers(users)
        }
    }

    fun toHistory() {
        navController?.let { nav ->
            viewModelScope.launch {
                nav.navigate(R.id.usersToHistory)
            }
        }
    }

    fun showUserDetails(uuid: String) {
        navController?.let { nav ->
            viewModelScope.launch {
                nav.navigate(R.id.usersToUser, bundleOf("userUuid" to uuid))
            }
        }
    }
}