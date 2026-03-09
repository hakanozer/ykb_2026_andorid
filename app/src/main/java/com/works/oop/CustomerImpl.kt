package com.works.oop

class CustomerImpl : ICustomer {
    override fun login(username: String, password: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun register(
        name: String,
        username: String,
        password: String
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun rememberPassword(username: String): String? {
        TODO("Not yet implemented")
    }

    override fun changePassword(
        username: String,
        oldPassword: String,
        newPassword: String
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun logout(username: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun deleteAccount(username: String, password: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun updateProfile(username: String, newName: String): Boolean {
        TODO("Not yet implemented")
    }
}