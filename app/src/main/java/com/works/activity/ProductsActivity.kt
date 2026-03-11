package com.works.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.works.R
import com.works.models.ProductsResponse
import com.works.service.JsonBulut
import com.works.utils.Client
import retrofit2.Call
import retrofit2.Response

class ProductsActivity : AppCompatActivity() {

    lateinit var jsonBulut: JsonBulut

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_products)

        jsonBulut = Client.retrofit.create(JsonBulut::class.java)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        pullProduct(1)
    }

    private fun pullProduct(page: Int) {
        val call = jsonBulut.products(page, 10)
        call.enqueue(object : retrofit2.Callback<ProductsResponse> {
            override fun onResponse(p0: Call<ProductsResponse?>?, p1: Response<ProductsResponse?>?) {
                if (p1!!.isSuccessful) {
                    val productsResponse = p1.body()
                    val products = productsResponse!!.data
                    Log.d("TAG", products.toString())
                }
            }

            override fun onFailure(p0: Call<ProductsResponse?>?, p1: Throwable?) {
                TODO("Not yet implemented")
            }

        })

    }


}