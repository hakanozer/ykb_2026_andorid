package com.works.activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.works.R
import com.works.models.LoginRequest
import com.works.models.LoginResponse
import com.works.service.JsonBulut
import com.works.utils.Client
import com.works.utils.Validations
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor


    lateinit var jsonBulut: JsonBulut

    lateinit var l_txtEmail: EditText
    lateinit var l_txtPassword: EditText
    lateinit var l_btnLogin: Button
    lateinit var l_btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_login)

        l_txtEmail = findViewById(R.id.l_txtEmail)
        l_txtPassword = findViewById(R.id.l_txtPassword)
        l_btnLogin = findViewById(R.id.l_btnLogin)
        l_btnRegister = findViewById(R.id.l_btnRegister)

        sharedPreferences = getSharedPreferences("app_pref", MODE_PRIVATE)
        editor = sharedPreferences.edit()
        jsonBulut = Client.retrofit.create(JsonBulut::class.java)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        l_btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        l_btnLogin.setOnClickListener {
            val email = l_txtEmail.text.toString()
            val password = l_txtPassword.text.toString()
            val valid = Validations()
            if (!valid.isValidEmail(email)) {
                showSnackBar("Email format is not valid")
                l_txtEmail.requestFocus()
            }else if (!valid.isValidPassword(password)) {
                showSnackBar("Password is not valid, min 6 characters")
                l_txtPassword.requestFocus()
            }else{
                val loginRequest = LoginRequest(email, password)
                val call = jsonBulut.login(loginRequest)
                call.enqueue(object: Callback<LoginResponse> {
                    override fun onResponse(p0: Call<LoginResponse?>?, p1: Response<LoginResponse?>?) {
                        if (p1!!.isSuccessful) {
                            val response = p1.body()
                            val token = response!!.data.access_token
                            editor.putString("token", token)
                            editor.putString("name", response.data.user.name)
                            editor.commit()
                            val intent = Intent(applicationContext, DashboardActivity::class.java)
                            startActivity(intent)
                            finish()
                        }else {
                            showSnackBar("Email or password is not valid")
                        }
                    }

                    override fun onFailure(p0: Call<LoginResponse?>?, p1: Throwable?) {
                        Toast.makeText(applicationContext, "onFailure", Toast.LENGTH_SHORT).show()
                    }
                })


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