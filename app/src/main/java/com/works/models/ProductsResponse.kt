package com.works.models

data class ProductsResponse(
    val meta: MetaProducts,
    val data: List<Product>
)

data class MetaProducts(
    val status: Int,
    val message: String,
    val pagination: Pagination
)

data class Pagination(
    val page: Int,
    val per_page: Int,
    val total_items: Int,
    val total_pages: Int
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

