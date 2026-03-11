package com.works.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.works.R
import com.works.adapter.ProductAdapter
import com.works.models.ProductsResponse
import com.works.service.JsonBulut
import com.works.utils.Client
import retrofit2.Call
import retrofit2.Response
import androidx.recyclerview.widget.LinearLayoutManager

class ProductsActivity : AppCompatActivity() {

    lateinit var productRecyclerView: RecyclerView
    lateinit var jsonBulut: JsonBulut

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_products)

        productRecyclerView = findViewById(R.id.productRecyclerView)
        productRecyclerView.layoutManager = LinearLayoutManager(this)
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
                    productRecyclerView.adapter = ProductAdapter(products)
                }
            }

            override fun onFailure(p0: Call<ProductsResponse?>?, p1: Throwable?) {
                TODO("Not yet implemented")
            }

        })

    }


}