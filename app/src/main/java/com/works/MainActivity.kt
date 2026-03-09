package com.works

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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
        mainFnc()
    }

    fun mainFnc() {

        // Geliştirme yaparken sonucu yazdırmak
        //print("Hello Android")
        Log.d("TAG", "mainFnc: ")

        // değişkenler
        // var, val
        // var -> Değer daha sonradan değişir
        // val -> readonly, Değer sabit

        var number = 10
        var number2 = 20
        var name = "Ali"
        name = "Veli"

        val surname = "Bilmem"
        val status = true
        val pi = 3.14

        print(name + surname)

        // Tür dönüşümü
        val stNum = "Ali"
        // try - catch
        try {
            // hata olma ihtimali olan kodlar
            val num = stNum.toInt() + 50
            Log.d("TAG", "$num" )
        } catch (e: Exception) {
            // hata olursa çalışacak kodlar
            Log.d("TAG", "Hata: Lütfen sayısal değer giriniz!")
        }

        // karar kontrol
        // if else
        val not = 85
        if (not >= 50) {
            Log.d("TAG", "Geçtiniz")
        } else {
            Log.d("TAG", "Kaldınız")
        }
        // == -> sağ taraf ile sol taraf eşit ise
        // != -> sağ taraf ile sol taraf eşit değilse
        // >  -> sağ taraf büyükse
        // <  -> sol taraf büyükse
        // >= -> sağ taraf büyük veya eşitse
        // <= -> sol taraf büyük veya eşitse
        // && -> ve
        // || -> veya

        // && örneği
        val username = "ali@mail.com"
        val password = "12345"
        if (username == "ali@mail.com" && password == "123456") {
            Log.d("TAG", "Giriş Yapıldı")
        } else {
            Log.d("TAG", "Giriş Yapılamadı")
        }

        // when
        val day = 6
        when (day) {
            1 -> Log.d("TAG", "Pazartesi")
            2 -> Log.d("TAG", "Salı")
            3 -> Log.d("TAG", "Çarşamba")
            4 -> Log.d("TAG", "Perşembe")
            5 -> Log.d("TAG", "Cuma")
            in 6..7 -> Log.d("TAG", "Hafta sonu tatil")
            else -> Log.d("TAG", "Böyle bir gün yok")
        }

        // for loop
        for (i in 1..10) {
            Log.d("TAG", "$i")
        }

        // for step
        for (i in 1..10 step 2) {
            Log.d("TAG", "Step : $i")
        }

        // for down to
        for (i in 10 downTo 1 step 2) {
            Log.d("TAG", "Down To : $i")
        }

        // while
        var i = 1
        while (i < 10) {
            Log.d("TAG", "While : $i")
            i++
        }

        // for - break - continue
        // break -> döngüyü bitir
        // continue -> adımı atla, döngünün başına dön
        for (i in 1..10) {
            if (i == 5) {
                continue
            }
            if (i == 8) {
                break
            }
            Log.d("TAG", "continue - Break : $i")
        }

        for (i in 1..100) {
            if (i == 5) {
                Log.d("TAG", "Break: $i")
                break
            }
        }

        // arrays
        val cities = arrayOf("İstanbul", "Ankara", "İzmir", "Bursa", "Adana", "Antalya")
        // item değerini yazdırma
        Log.d("TAG", "cities[0]: ${cities[0]}")
        // item değerini değiştirme
        cities[0] = "İstanbulx"
        Log.d("TAG", "cities[0]: ${cities[0]}")
        // array uzunluğu
        Log.d("TAG", "cities.size: ${cities.size}")
        // array son elemanı
        Log.d("TAG", "cities.last(): ${cities.last()}")
        // array ilk elemanı
        Log.d("TAG", "cities.first(): ${cities.first()}")











    }
}