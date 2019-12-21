package com.mg.manager

import com.mg.manager.base.BaseDataManager
import com.mg.remote.model.Category
import com.mg.remote.network.NetworkState
import com.mg.remote.service.ICategoryService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DataManager(private val categoryService: ICategoryService) : BaseDataManager(), IDataManager {

    override fun getCategories(): Flow<NetworkState<ArrayList<Category>>> = flow {
        emit(apiCall { categoryService.categories() })
    }

}