package com.mg.manager

import com.mg.local.dao.SoundDao
import com.mg.local.entity.SoundEntity
import com.mg.manager.base.BaseDataManager
import com.mg.remote.model.Category
import com.mg.remote.model.Sound
import com.mg.remote.network.NetworkState
import com.mg.remote.service.ICategoryService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DataManager(
    private val categoryService: ICategoryService,
    private val soundDao: SoundDao
) : BaseDataManager(), IDataManager {

    override fun getCategories(): Flow<NetworkState<ArrayList<Category>>> = flow {
        emit(apiCall { categoryService.categories() })
    }

    override fun getCategoryDetails(): Flow<NetworkState<ArrayList<Sound>>> = flow {
        emit(apiCall { categoryService.categoryDetail() })
    }

    override fun getFavorites(): Flow<NetworkState<ArrayList<Sound>>> = flow {
        emit(apiCall { categoryService.favorites() })
    }

    override suspend fun getFavSounds(): List<SoundEntity> = soundDao.favSounds()

    override suspend fun insertSound(soundEntity: SoundEntity) = soundDao.insert(soundEntity)

    override suspend fun getSounds(): List<SoundEntity> = soundDao.sounds()
}