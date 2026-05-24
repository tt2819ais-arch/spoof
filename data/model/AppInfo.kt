package com.cameraspoof.data.model

import android.graphics.drawable.Drawable

data class AppInfo(
    val packageName: String,
    val appName: String,
    val icon: Drawable?,
    val isSystemApp: Boolean,
    val versionName: String?,
    val versionCode: Long
)

data class AppConfig(
    val packageName: String,
    val isEnabled: Boolean = false,
    val spoofMode: SpoofMode = SpoofMode.STATIC_JPEG,
    val selectedImagePath: String? = null,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis(),
    val hookTriggeredCount: Int = 0,
    val lastHookTimestamp: Long? = null
)

data class AppWithConfig(
    val appInfo: AppInfo,
    val config: AppConfig?
)

data class LogEntry(
    val id: Long = 0,
    val timestamp: Long = System.currentTimeMillis(),
    val level: LogLevel = LogLevel.INFO,
    val packageName: String? = null,
    val tag: String = "CameraSpoof",
    val message: String,
    val extraData: String? = null
)
