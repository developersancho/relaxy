package com.mg.manager

import com.mg.local.entity.SoundEntity
import com.mg.remote.model.Category
import com.mg.remote.model.CategoryDetail
import com.mg.remote.network.NetworkState
import kotlinx.coroutines.flow.Flow

interface IDataManager {

    fun getCategories(): Flow<NetworkState<ArrayList<Category>>>

    fun getCategoryDetails(): Flow<NetworkState<ArrayList<CategoryDetail>>>

    suspend fun insertSound(soundEntity: SoundEntity)

    suspend fun getSounds(): List<SoundEntity>

}