package com.works.models

data class ProductDetailResponse(
    val meta: Meta,
    val data: Product
) {

    data class Meta(
        val status: Int,
        val message: String
    )

    data class Product(
        val id: Int,
        val title: String,
        val description: String,
        val category: String,
        val price: Double,
        val discountPercentage: Double,
        val rating: Double,
        val stock: Int,
        val tags: List<String>,
        val brand: String,
        val sku: String,
        val minimumOrderQuantity: Int,
        val images: List<String>
    )

}
