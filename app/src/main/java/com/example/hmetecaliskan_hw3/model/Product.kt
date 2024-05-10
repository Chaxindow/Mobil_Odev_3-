package com.example.hmetecaliskan_hw3.model

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("title")
    val title : String,
    @SerializedName("price")
    val price : String,
    @SerializedName("image")
    val imageUrl : String
)
