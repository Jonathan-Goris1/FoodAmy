package com.zybooks.foodamy.presentation.register_info

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
import javax.inject.Inject

@HiltViewModel
class RegisterInfoViewModel@Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: AuthRepository
) : ViewModel() {

    private val tag = "RegisterViewModel"
    var state by mutableStateOf(RegisterInfoState())

    fun updateUsername(username: String){
        state = state.copy(username = username)
    }

    fun updateEmail(email: String){
        state = state.copy(email = email)
    }

    fun validateEmail(): Boolean{
        val email = state.email
        return if(email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Log.d(tag, "Email Validated Successfully")
            false
        }else{
            Log.d(tag, "Invalid Email Address")
            true
        }
    }

    fun updatePassword(password: String){
        state = state.copy(password = password)
    }


    init {
        viewModelScope.launch {
            val email = savedStateHandle.get<String>("email") ?: return@launch
            val password = savedStateHandle.get<String>("password") ?: return@launch
            state = state.copy(isLoading = true)
            val loginInfoResult = async { repository.postRegisterInfo(email, password, "", "", "", "", "")}
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