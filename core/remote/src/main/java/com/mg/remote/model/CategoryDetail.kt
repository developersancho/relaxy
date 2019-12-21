package com.mg.remote.model


import com.google.gson.annotations.SerializedName

data class CategoryDetail(

    @SerializedName("category_id")
    var categoryId: Int,

    @SerializedName("id")
    var id: Int,

    @SerializedName("sound_url")
    var soundUrl: String,

    @SerializedName("title")
    var title: String,

    @SerializedName("isFav")
    var isFav: Boolean

)