package com.works.service

import com.works.models.LoginRequest
import com.works.models.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface JsonBulut {

    @POST("auth/login")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>


}