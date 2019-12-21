package com.mg.manager

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

    @Before
    fun setUpData() {
        MockitoAnnotations.initMocks(this)
        dataManager = DataManager(categoryService)
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

}