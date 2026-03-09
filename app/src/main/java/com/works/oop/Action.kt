package com.works.oop

import android.util.Log

class Action(var name: String) {

    val number = 100 // default hal public -> her yerden görün
    private var city = "İstanbul" // private ->sadece kendi sınıfında görün

    protected var area = 34400 // protected -> sadece kendi sınıfı ve alt sınıfları görünür



    fun report() {
        Log.d("TAG", city)
        Log.d("TAG", name)
    }

    fun sum(num1: Int, num2: Int) : Int {
        //Log.d("TAG", "sum: ${num1 + num2}")
        return num1 + num2
    }

    fun dayReport(day: EDays) {
        when (day) {
            EDays.pazartesi -> Log.d("TAG", "Pazartesi")
            EDays.sali -> Log.d("TAG", "Salı")
            EDays.carsamba -> Log.d("TAG", "Çarşamba")
            EDays.persembe -> Log.d("TAG", "Perşembe")
            EDays.cuma -> Log.d("TAG", "Cuma")
        }
    }

}