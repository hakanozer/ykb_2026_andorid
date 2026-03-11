package com.works.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.works.R
import com.works.models.ProductDetailResponse
import com.works.service.JsonBulut
import com.works.utils.Client
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductDetailActivity : AppCompatActivity() {

    lateinit var jsonBulut: JsonBulut


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_product_detail)

        val id = intent.getIntExtra("id", 0)
        if (id == 0) {
            finish()
        }else {
            jsonBulut = Client.retrofit.create(JsonBulut::class.java)
            val call = jsonBulut.productDetail(id)
            call.enqueue(object: Callback<ProductDetailResponse> {
                override fun onResponse(p0: Call<ProductDetailResponse?>?, p1: Response<ProductDetailResponse?>?) {
                    if (p1!!.isSuccessful) {
                        val productDetailResponse = p1.body()
                        val product = productDetailResponse!!.data
                        Log.e("product", product.toString())
                    }
                }

                override fun onFailure(p0: Call<ProductDetailResponse?>?, p1: Throwable?) {
                    TODO("Not yet implemented")
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