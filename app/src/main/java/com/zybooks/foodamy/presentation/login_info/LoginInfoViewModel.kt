package com.zybooks.foodamy.presentation.login_info

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zybooks.foodamy.domain.repository.AuthRepository
import com.zybooks.foodamy.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class LoginInfoViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: AuthRepository
) : ViewModel() {

    private val tag = "LoginViewModel"
    var state by mutableStateOf(LoginInfoState())

    fun updateEmail(email: String){
        state = state.copy(email = email)
    }
    fun updatePassword(password: String){
        state = state.copy(password = password)
    }


    fun validateEmail(): Boolean{
        val email = state.email
        state = if(email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Log.d(tag, "Email Validated Successfully")
            state.copy(isEmailError = false)
        }else{
            Log.d(tag, "Invalid Email Address")
            state.copy(isEmailError = true)
        }
        return state.isEmailError
    }

    fun validatePassword(): Boolean{
        val password = state.password
        val textPattern: Pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[(\"[!@#\$%&*()_+=|<>?{}\\\\[\\\\]]]).+$")
         if(password.isNotEmpty() && password.length >= 8 && textPattern.matcher(password).matches()) {
            Log.d(tag, "Password Validated Successfully")
            state.copy(isPasswordError = false)
        }else{
            Log.d(tag, "Invalid Password")
            state.copy(isPasswordError = true)
        }
        return state.isPasswordError
    }




    init {
        viewModelScope.launch {
            val email = savedStateHandle.get<String>("email") ?: return@launch
            val password = savedStateHandle.get<String>("password") ?: return@launch
            state = state.copy(isLoading = true)
            val loginInfoResult = async { repository.postLoginInfo(email, password)}
            when(val result = loginInfoResult.await()){
                is Resource.Success -> {
                    state = state.copy(
                        isLoading = false,
                        error = null
                    )

                }
                is Resource.Error -> {
                    state = state.copy(
                        isLoading = false,
                        error = result.message,
                    )

                }
                else -> Unit
            }


        }
    }
}