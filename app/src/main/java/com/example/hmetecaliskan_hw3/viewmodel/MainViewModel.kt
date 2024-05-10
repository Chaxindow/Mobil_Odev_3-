package com.example.hmetecaliskan_hw3.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hmetecaliskan_hw3.model.Product
import com.example.hmetecaliskan_hw3.service.ProductAPIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val productApi = ProductAPIService()

    val productData = MutableLiveData<List<Product>>()
    val productLoad = MutableLiveData<Boolean>()
    val productError = MutableLiveData<Boolean>()


    @SuppressLint("SuspiciousIndentation")
    fun getDataFromAPI(){
    productLoad.value = true

        productApi.getData().enqueue(object : Callback<List<Product>>{
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                productData.value = response.body()
                productLoad.value = false
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                productError.value= true
                productLoad.value = false
                Log.e("RetrofitError",t.message.toString())
            }
        })
    }
}