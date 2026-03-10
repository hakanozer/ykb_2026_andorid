package com.works.oop

import com.works.oop.inheritance.Worker

class Main {
    /*
    val objStart = Start()
        objStart.mainFnc()

        // action -> nesne adı
        // Action() -> class name
        val action = Action("Erkan")
        action.report()
        val sum1 = action.sum(60, 80)
        val sum2 = action.sum(44, 33)
        val sum3 = action.sum(11, 99)

        Log.d("TAG", "sum1: $sum1")
        Log.d("TAG", "sum2: $sum2")
        Log.d("TAG", "sum3: $sum3")

        val user1 = User(1, "Ali", "ali@mail.com", "12345")
        val user2 = User(2, "Veli", "veli@mail.com", "12345")
        val user3 = User(3, "Ahmet", "ahmet@mail.com", "12345")
        val user4 = User(4, "Mehmet", "mehmet@mail.com", "12345")

        // users array
        val users = arrayOf(user1, user2, user3, user4)
        for (user in users) {
            Log.d("TAG", "id: ${user.username}")
        }
        action.number

        val u1 = SuperAdmin("Ali", "Bilmem", 25)
        val u2 = Admin("Veli", "Bilirim", 30)
        val u3 = Customer("Ahmet", "Bil", 35)

        call(u1)
        call(u2)
        call(u3)

        // Start.apiKey
        Log.d("TAG", "apiKey: ${Start.apiKey}")

        action.dayReport(EDays.persembe)

        val objMutableArray = MutableArray()
        objMutableArray.fncMutableArray()
        objMutableArray.mutableSetOf()
        objMutableArray.mutableMapOf()
     */

    fun call(obj: Worker) {
        obj.report()
    }
}