package com.works.oop.inheritance

import android.util.Log

open class Worker(var name: String, var surname: String,  var age: Int ) {

    fun report() {
        Log.d("TAG", "$name $surname $age - ${allowYear()}")
    }

    // yıllık izin fonksiyon
    open fun allowYear() : Int {
        return 0
    }

}