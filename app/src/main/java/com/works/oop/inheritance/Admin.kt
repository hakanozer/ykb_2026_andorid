package com.works.oop.inheritance

class Admin (name: String, surname: String, age: Int)
    :
    Worker(name, surname, age)
{

    override fun allowYear(): Int {
        return 20
    }

}