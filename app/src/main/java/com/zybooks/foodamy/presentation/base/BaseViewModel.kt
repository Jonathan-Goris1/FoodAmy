package com.zybooks.foodamy.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class BaseViewModel: ViewModel() {

    fun <T> sendRequest(
        loading: Boolean = false,
        request: suspend () -> T,
        success: (suspend (T) -> Unit)? = null,
        error: ((Exception) -> Unit)? = null
    ): Job {
        return viewModelScope.launch {
            try {
                val response = request.invoke()
                success?.invoke(response)

            } catch (ex: Exception) {

                if (error == null)
                    handleException(ex)
                else error.invoke(ex)
            }
        }
    }

    private fun handleException(ex: Exception) {
//        when (ex) {
//            is Authentication -> showMessageWithRes(R.string.try_to_login)
//            is IOException -> showMessageWithRes(R.string.check_internet_connection)
//            is GettingEmptyListItem -> showMessageWithRes(R.string.no_comment_in_list)
//            is SimpleHttpException -> showMessage(ex.friendlyMessage)
//            else -> {
//                ex.printStackTrace()
//            }
//        }
    }
}