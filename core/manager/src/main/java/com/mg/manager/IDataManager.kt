package com.mg.manager

import com.mg.remote.model.Category
import com.mg.remote.network.NetworkState
import kotlinx.coroutines.flow.Flow

interface IDataManager {

    fun getCategories(): Flow<NetworkState<ArrayList<Category>>>

}