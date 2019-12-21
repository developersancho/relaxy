package com.mg.remote.service

import com.mg.remote.model.Category
import retrofit2.http.GET

interface ICategoryService {

    @GET("categories.html")
    suspend fun categories(): ArrayList<Category>

}