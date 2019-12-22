package com.mg.remote

import com.mg.remote.service.ICategoryService
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.test.inject

@RunWith(JUnit4::class)
class CategoryServiceTest : BaseServiceTest() {

    private val categoryService by inject<ICategoryService>()

    @Test
    fun check_category() = runBlocking {
        val response = categoryService.categories()

        Assert.assertEquals(3, response?.size)
        Assert.assertEquals(1000, response?.first().categoryId)
    }

    @Test
    fun check_category_detail() = runBlocking {
        val response = categoryService.categoryDetail()

        Assert.assertEquals(10, response?.size)
        Assert.assertEquals(1000, response?.first().categoryId)
    }

    @Test
    fun check_favorites() = runBlocking {
        val response = categoryService.favorites()

        Assert.assertEquals(4, response?.size)
        Assert.assertEquals(2000, response?.first().id)
    }

}