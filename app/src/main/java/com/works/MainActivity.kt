package com.works

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.works.oop.Action
import com.works.oop.EDays
import com.works.oop.Start
import com.works.oop.User
import com.works.oop.inheritance.Admin
import com.works.oop.inheritance.Customer
import com.works.oop.inheritance.SuperAdmin
import com.works.oop.inheritance.Worker
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
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
    }

    fun call(obj: Worker) {
        obj.report()
    }


}