package com.pce.android.track20.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pce.android.track20.internal.typeconverter.StringArrayTypeConverter

@Database(entities = [], version = 1)
@TypeConverters(StringArrayTypeConverter::class)
abstract class Track20Database : RoomDatabase() {

    companion object {
        @Volatile
        private var instance: Track20Database? = null
        private val LOCK = Any()
        private const val DATABASE_NAME = "track_20_db"
        operator fun invoke(context: Context): Track20Database = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            Track20Database::class.java,
            DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}