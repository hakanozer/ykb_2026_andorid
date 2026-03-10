package com.works.oop

import android.util.Log

class MutableArray {

    fun fncMutableArray() {

        val cities = mutableListOf<String>()

        // item ekleme
        cities.add("İstanbul")
        cities.add("Ankara")
        cities.add("Ankara")
        cities.add("İzmir")
        cities.add("Bursa")
        cities.add("Adana")
        cities.add("Antalya")
        cities.add("Antalya")
        cities.add("Gaziantep")
        cities.add("Samsun")

        Log.d("TAG", cities.toString())

        // item silme
        cities.removeAt(3)
        Log.d("TAG", cities.toString())

        // item güncelleme
        cities[0] = "İstanbulx"
        Log.d("TAG", cities.toString())

        cities.reverse()
        Log.d("TAG", cities.toString())

        cities.sort()
        Log.d("TAG", cities.toString())

        //cities.clear()
        //Log.d("TAG", cities.toString())

    }


    fun mutableSetOf() {
        val cities = mutableSetOf<String>()
        // item ekleme
        cities.add("İstanbul")
        cities.add("Ankara")
        cities.add("Ankara")
        cities.add("İzmir")
        cities.add("Bursa")
        cities.add("Adana")
        cities.add("Antalya")
        cities.add("Antalya")
        cities.add("Gaziantep")
        cities.add("Samsun")

        Log.d("TAG", cities.toString())

    }

    fun mutableMapOf() {

        val user = mutableMapOf<String, Any>()
        user["name"] = "Ali"
        user["surname"] = "Bilmem"
        user["age"] = 25
        user["city"] = "İstanbul"
        user["status"] = true

        Log.d("TAG", user["age"].toString())

        Log.d("TAG", user.toString())

    }

}