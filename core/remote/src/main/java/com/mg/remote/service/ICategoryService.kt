package com.mg.remote.service

import com.mg.remote.model.Category
import com.mg.remote.model.CategoryDetail
import retrofit2.http.GET

interface ICategoryService {

    @GET("categories.html")
    suspend fun categories(): ArrayList<Category>

    @GET("category_detail.html")
    suspend fun categoryDetail(): ArrayList<CategoryDetail>

}