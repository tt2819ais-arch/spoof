package com.cameraspoof.data.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import android.content.Context
import com.cameraspoof.data.db.converter.Converters
import com.cameraspoof.data.db.dao.AppConfigDao
import com.cameraspoof.data.db.dao.LogEntryDao
import com.cameraspoof.data.db.entity.AppConfigEntity
import com.cameraspoof.data.db.entity.LogEntryEntity

@Database(
    entities = [AppConfigEntity::class, LogEntryEntity::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun appConfigDao(): AppConfigDao
    abstract fun logEntryDao(): LogEntryDao

    companion object {
        const val DATABASE_NAME = "cameraspoof_db"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
