package com.ferdian.todocleanarchitecture.data.product.remote.dto

import com.google.gson.annotations.SerializedName

data class ProductCreateRequest(
    @SerializedName("name") val productName: String,
    @SerializedName("price") val price : Int
)