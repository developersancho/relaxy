package com.mg.remote.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Category(

    @SerializedName("id")
    val categoryId: Int,

    @SerializedName("category_title")
    val categoryTitle: String,

    @SerializedName("background_url")
    val categoryImage: String

) : Serializable