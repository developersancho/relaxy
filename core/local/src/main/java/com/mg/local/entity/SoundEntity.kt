package com.mg.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Sound_Table")
class SoundEntity(
    @PrimaryKey
    var soundId: Int? = 0,
    var isFav: Boolean = false,
    var categoryId: Int,
    var soundUrl: String,
    var title: String
)