package com.zybooks.foodamy.data.local.local_dto

data class ImageDb(
    val height: Int,
    val url: String,
    val width: Int
){
    companion object {
        val EMPTY = ImageDb(0, "", 0)
    }
}


