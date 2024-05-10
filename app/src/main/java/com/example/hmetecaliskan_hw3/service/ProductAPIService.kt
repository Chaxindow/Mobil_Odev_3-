package com.example.hmetecaliskan_hw3.service

import com.example.hmetecaliskan_hw3.model.Product
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductAPIService {

    private val baseURL = "https://fakestoreapi.com"

    private val api = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ProductAPI::class.java)

    fun getData() : Call<List<Product>>{
        return api.getProducts()
    }


}