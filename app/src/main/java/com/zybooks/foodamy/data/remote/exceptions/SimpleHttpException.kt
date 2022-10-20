package com.zybooks.foodamy.data.remote.exceptions

data class SimpleHttpException (
    val code: String?,
    val friendlyMessage: String?
) : Exception()