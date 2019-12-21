package com.mg.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mg.local.dao.SoundDao
import com.mg.local.entity.SoundEntity

@Database(
    entities = [SoundEntity::class],
    version = 1,
    exportSchema = false
)
abstract class CoreDatabase : RoomDatabase() {
    abstract fun soundDao(): SoundDao
}