package com.zybooks.foodamy.util


import android.util.Patterns
import java.util.regex.Pattern


object Validations {

    fun validateEmail(email: String): Boolean {
        return !(email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches())

    }


    fun validatePassword(password: String): Boolean {
        val textPattern: Pattern =
            Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[(\"!@#\$%&*_+=|<>?{}\\\\]).+$")
        return !(password.isNotEmpty() && password.length >= 8 && textPattern.matcher(password)
            .matches())
    }
}