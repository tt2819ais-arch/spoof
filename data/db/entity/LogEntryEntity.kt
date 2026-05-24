package com.cameraspoof.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cameraspoof.data.model.LogLevel

@Entity(tableName = "log_entries")
data class LogEntryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    @ColumnInfo(name = "timestamp")
    val timestamp: Long = System.currentTimeMillis(),

    @ColumnInfo(name = "level")
    val level: LogLevel = LogLevel.INFO,

    @ColumnInfo(name = "package_name")
    val packageName: String? = null,

    @ColumnInfo(name = "tag")
    val tag: String = "CameraSpoof",

    @ColumnInfo(name = "message")
    val message: String,

    @ColumnInfo(name = "extra_data")
    val extraData: String? = null
)
