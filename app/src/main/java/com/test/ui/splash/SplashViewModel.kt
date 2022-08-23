package com.test.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.test.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel: ViewModel() {

    var content = "Splash"
        private set

    fun initNavigation(nav: NavController) {
        viewModelScope.launch {
            delay(2000)
            nav.navigate(R.id.splashToUsers)
        }
    }
}