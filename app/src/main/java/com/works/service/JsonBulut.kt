package com.works.service

import com.works.models.LoginRequest
import com.works.models.LoginResponse
import com.works.models.ProductDetailResponse
import com.works.models.ProductsResponse
import com.works.models.ProfileResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface JsonBulut {

    @POST("auth/login")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>

    @GET("profile/me")
    fun profile(@Header("Authorization") token: String): Call<ProfileResponse>

    @GET("products")
    fun products(@Query("page") page: Int, @Query("per_page") perPage: Int): Call<ProductsResponse>


    @GET("products/{id}")
    fun productDetail(@Path("id") id: Int): Call<ProductDetailResponse>

}