package com.zybooks.foodamy.presentation.login_info

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zybooks.foodamy.domain.repository.AuthRepository
import com.zybooks.foodamy.util.Resource
import com.zybooks.foodamy.util.Validations
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginInfoViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    var state by mutableStateOf(LoginInfoState())

    fun updateEmail(email: String){
        state = state.copy(email = email)

    }
    fun updatePassword(password: String){
        state = state.copy(password = password)

    }


    private fun validateEmail(): Boolean = Validations.validateEmail(state.email)


    private fun validatePassword(): Boolean = Validations.validatePassword(state.password)


    fun login() {
        if(!validateEmail() && !validatePassword()){
            viewModelScope.launch {
                state = state.copy(isLoading = true)
                when(val loginInfoResult =  repository.postLoginInfo(state.email, state.password)){
                    is Resource.Success -> {
                        state = state.copy(
                            isLoading = false,
                            error = null
                        )
                    }
                    is Resource.Error -> {
                        state = state.copy(
                            isLoading = false,
                            error = loginInfoResult.message,
                        )

                    }
                    else -> {}
                }
                state = state.copy(isLoading = false)
            }
        }
    }
}