package com.works.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil3.load
import com.works.R
import com.works.models.Product

class ProductItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindItem(product: Product) {
        val title = itemView.findViewById<TextView>(R.id.pr_title)
        val price = itemView.findViewById<TextView>(R.id.pr_price)
        val image = itemView.findViewById<ImageView>(R.id.pr_image)

        title.text = product.title
        price.text = "${product.price} ₺"

        val url = product.images[0]
        image.load(url)
    }

}