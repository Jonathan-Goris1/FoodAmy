package com.zybooks.foodamy.data.local.local_dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.zybooks.foodamy.data.utils.RemoteKey

@Entity(tableName = "remote_key_comments")
data class RemoteKeyComment(
    @PrimaryKey(autoGenerate = false)
    override val id: Int,
    override val next: Int?,
    override val prev: Int?
) : RemoteKey