package com.mg.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.mg.local.entity.SoundEntity

@Dao
interface SoundDao : BaseDao<SoundEntity> {
    @Query("DELETE FROM Sound_Table")
    suspend fun deleteAll()

    @Query("select * from Sound_Table")
    suspend fun sounds(): List<SoundEntity>

    @Query("select * from Sound_Table where soundId= :id")
    suspend fun sound(id: Int): SoundEntity
}