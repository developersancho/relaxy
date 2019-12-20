package com.mg.local.db

import androidx.room.Database
import androidx.room.RoomDatabase

/*@Database(
    entities = [],
    version = 1,
    exportSchema = false
)*/
abstract class CoreDatabase: RoomDatabase() {
    //abstract fun daoName(): DaoName
}