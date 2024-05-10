package com.example.hmetecaliskan_hw3.view

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hmetecaliskan_hw3.R
import com.example.hmetecaliskan_hw3.adapter.ItemAdapter
import com.example.hmetecaliskan_hw3.databinding.ActivityMainBinding
import com.example.hmetecaliskan_hw3.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel : MainViewModel
    private lateinit var binding : ActivityMainBinding
    private lateinit var itemAdapter : ItemAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        itemAdapter = ItemAdapter(ArrayList())
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.RVItem.adapter = itemAdapter
        binding.RVItem.layoutManager = LinearLayoutManager(this)

        viewModel.getDataFromAPI()

        setObservers()
    }

    private fun setObservers(){

        viewModel.productData.observe(this) { list ->
            itemAdapter.updateList(list)
        }
        viewModel.productLoad.observe(this){ load ->
           if(load) binding.PBId.visibility = View.VISIBLE
           else binding.PBId.visibility = View.GONE
        }
        viewModel.productError.observe(this){ error ->
            if(error) binding.TVError.visibility = View.VISIBLE
            else  binding.TVError.visibility = View.GONE
        }
    }
}




