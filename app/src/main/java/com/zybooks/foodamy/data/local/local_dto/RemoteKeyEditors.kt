package com.zybooks.foodamy.data.local.local_dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.zybooks.foodamy.data.utils.RemoteKey

@Entity(tableName = "remote_keys_editor")
data class RemoteKeysEditor(
    @PrimaryKey(autoGenerate = false)
    override val id: Int,
    override val prev: Int?,
    override val next: Int?
) : RemoteKey
