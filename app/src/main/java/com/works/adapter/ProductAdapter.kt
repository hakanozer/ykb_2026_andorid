package com.works.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.works.R
import com.works.models.Product

class ProductAdapter (private val list: List<Product>): RecyclerView.Adapter<ProductItemHolder>()
{
    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): ProductItemHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.product_item, p0, false)
        val proView = ProductItemHolder(view)
        return proView
    }

    override fun onBindViewHolder(p0: ProductItemHolder, p1: Int) {
        p0.bindItem(list[p1])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}