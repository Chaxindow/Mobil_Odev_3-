package com.example.hmetecaliskan_hw3.util

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.downloadUrl(url: String) {
    Glide.with(this).load(url).into(this)
}