package com.works.oop

interface ICustomer {

    fun login(username: String, password: String) : Boolean

    fun register(name: String, username: String, password: String) : Boolean

    fun rememberPassword(username: String) : String?

    fun changePassword(username: String, oldPassword: String, newPassword: String) : Boolean

    fun logout(username: String) : Boolean

    fun deleteAccount(username: String, password: String) : Boolean

    fun updateProfile(username: String, newName: String) : Boolean
}