package com.cameraspoof.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cameraspoof.data.model.SpoofMode

@Entity(tableName = "app_configs")
data class AppConfigEntity(
    @PrimaryKey
    @ColumnInfo(name = "package_name")
    val packageName: String,

    @ColumnInfo(name = "is_enabled")
    val isEnabled: Boolean = false,

    @ColumnInfo(name = "spoof_mode")
    val spoofMode: SpoofMode = SpoofMode.STATIC_JPEG,

    @ColumnInfo(name = "selected_image_path")
    val selectedImagePath: String? = null,

    @ColumnInfo(name = "created_at")
    val createdAt: Long = System.currentTimeMillis(),

    @ColumnInfo(name = "updated_at")
    val updatedAt: Long = System.currentTimeMillis(),

    @ColumnInfo(name = "hook_triggered_count")
    val hookTriggeredCount: Int = 0,

    @ColumnInfo(name = "last_hook_timestamp")
    val lastHookTimestamp: Long? = null
)
