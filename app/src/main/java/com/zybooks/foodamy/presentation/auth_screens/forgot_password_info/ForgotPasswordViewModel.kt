package com.zybooks.foodamy.presentation.auth_screens.forgot_password_info

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.zybooks.foodamy.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: AuthRepository
) : ViewModel() {

    private val tag = "ForgotPasswordViewModel"
    var state by mutableStateOf(ForgotPasswordState())

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
}