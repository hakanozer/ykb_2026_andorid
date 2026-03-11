package com.works.models

data class ProfileResponse(
    val meta: MetaProfile,
    val data: UserProfile
)

data class MetaProfile(
    val status: Int,
    val message: String
)

data class UserProfile(
    val id: Int,
    val name: String,
    val email: String,
    val role: String,
    val remember_token: String?,
    val created_at: String,
    val updated_at: String
)
