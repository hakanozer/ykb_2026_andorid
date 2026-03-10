package com.works.activity

import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.works.R

class RegisterActivity : AppCompatActivity() {

    lateinit var r_btnBackLogin: Button
    lateinit var r_btnRegister: Button
    lateinit var r_swich: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        r_btnBackLogin = findViewById(R.id.r_btnBackLogin)
        r_btnRegister = findViewById(R.id.r_btnRegister)
        r_swich = findViewById(R.id.r_swich)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        r_btnBackLogin.setOnClickListener {
            finish()
        }

        r_btnRegister.setOnClickListener {
            val status = r_swich.isChecked
            if (status) {
                showToast("Register successful")
            } else {
                showSnackBar("Please accept the terms and conditions")
            }
        }

    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun showSnackBar(message: String) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show()
    }


}