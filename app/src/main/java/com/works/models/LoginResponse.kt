package com.works.models

data class LoginResponse(
    val meta: Meta,
    val data: Data
)

data class Meta(
    val status: Int,
    val message: String
)

data class Data(
    val access_token: String,
    val token_type: String,
    val expires_in: Int,
    val user: User
)

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val role: String,
    val remember_token: String?,
    val created_at: String,
    val updated_at: String
)