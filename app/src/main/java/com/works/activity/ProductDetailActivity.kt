package com.works.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.works.R
import com.works.models.ProductDetailResponse
import com.works.service.JsonBulut
import com.works.utils.Client
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductDetailActivity : AppCompatActivity() {

    lateinit var jsonBulut: JsonBulut

    lateinit var imgProduct: ImageView
    lateinit var txtTitle: TextView
    lateinit var txtBrand: TextView
    lateinit var txtPrice: TextView
    lateinit var txtDiscount: TextView
    lateinit var txtStock: TextView
    lateinit var txtDescription: TextView
    lateinit var ratingBar: RatingBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_product_detail)

        // View Tanımları
        imgProduct = findViewById(R.id.imgProduct)
        txtTitle = findViewById(R.id.txtTitle)
        txtBrand = findViewById(R.id.txtBrand)
        txtPrice = findViewById(R.id.txtPrice)
        txtDiscount = findViewById(R.id.txtDiscount)
        txtStock = findViewById(R.id.txtStock)
        txtDescription = findViewById(R.id.txtDescription)
        ratingBar = findViewById(R.id.ratingBar)

        val id = intent.getIntExtra("id", 0)

        if (id == 0) {
            finish()
        } else {

            jsonBulut = Client.retrofit.create(JsonBulut::class.java)

            val call = jsonBulut.productDetail(id)

            call.enqueue(object : Callback<ProductDetailResponse> {

                override fun onResponse(call: Call<ProductDetailResponse>, response: Response<ProductDetailResponse>) {

                    if (response.isSuccessful) {
                        val product = response.body()!!.data
                        txtTitle.text = product.title
                        txtBrand.text = "Brand : ${product.brand}"
                        txtPrice.text = "$${product.price}"
                        txtDiscount.text = "%${product.discountPercentage} indirim"
                        txtStock.text = "Stock : ${product.stock}"
                        txtDescription.text = product.description
                        ratingBar.rating = product.rating.toFloat()
                        if (product.images.isNotEmpty()) {
                            Glide
                                .with(this@ProductDetailActivity)
                                .load(product.images[0])
                                .into(imgProduct)
                        }
                    }
                }

                override fun onFailure(call: Call<ProductDetailResponse>, t: Throwable) {
                    t.printStackTrace()
                }

            })
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}