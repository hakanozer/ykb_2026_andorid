package com.works.oop.inheritance

class SuperAdmin
    (name: String, surname: String, age: Int)
    :
    Worker(name, surname, age)
{

    override fun allowYear(): Int {
        return 45
    }

}