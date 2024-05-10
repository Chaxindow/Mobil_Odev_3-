package com.example.hmetecaliskan_hw3.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.hmetecaliskan_hw3.R
import com.example.hmetecaliskan_hw3.util.downloadUrl
import com.example.hmetecaliskan_hw3.databinding.ItemBinding
import com.example.hmetecaliskan_hw3.model.Product

class ItemAdapter(private var itemList : ArrayList<Product>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder( var view : ItemBinding) :RecyclerView.ViewHolder(view.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemBinding>(inflater, R.layout.item,parent,false)

        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  itemList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        holder.view.TVTitle.text = itemList[position].title
        holder.view.TVPrice.text = "${itemList[position].price}$"
        holder.view.IVProduct.downloadUrl(itemList[position].imageUrl)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun  updateList(newList: List<Product>){
        itemList = newList as ArrayList<Product>
        notifyDataSetChanged()
    }
}

