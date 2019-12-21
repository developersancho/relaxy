package com.mg.manager

import com.mg.local.dao.SoundDao
import com.mg.remote.network.NetworkState
import com.mg.remote.service.ICategoryService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.koin.test.inject
import org.mockito.MockitoAnnotations
import timber.log.Timber

@ExperimentalCoroutinesApi
class DataManagerTest : BaseDataManagerTest() {

    private val categoryService by inject<ICategoryService>()
    private val soundDao by inject<SoundDao>()

    @Before
    fun setUpData() {
        MockitoAnnotations.initMocks(this)
        dataManager = DataManager(categoryService, soundDao)
    }

    @Test
    fun `Get Categories`() = runBlocking {
        dataManager.getCategories().collect {
            when (it) {
                is NetworkState.Success -> {
                    Assert.assertEquals(3, it.data.size)
                }

                is NetworkState.Error -> {
                    Timber.d("NetworkState.Error : ${it.exception.message}")
                }
            }
        }
    }

    @Test
    fun `Get Category Details`() = runBlocking {
        dataManager.getCategoryDetails().collect {
            when (it) {
                is NetworkState.Success -> {
                    Assert.assertEquals(10, it.data.size)
                }

                is NetworkState.Error -> {
                    Timber.d("NetworkState.Error : ${it.exception.message}")
                }
            }
        }
    }

    @Test
    fun `Get Favorites`() = runBlocking {
        dataManager.getFavorites().collect {
            when (it) {
                is NetworkState.Success -> {
                    Assert.assertEquals(4, it.data.size)
                }

                is NetworkState.Error -> {
                    Timber.d("NetworkState.Error : ${it.exception.message}")
                }
            }
        }
    }

}