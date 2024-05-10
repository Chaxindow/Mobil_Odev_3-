package com.example.hmetecaliskan_hw3.service

import com.example.hmetecaliskan_hw3.model.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductAPI {

    // https://fakestoreapi.com/products

    @GET("/products")
    fun getProducts() : Call<List<Product>>
}