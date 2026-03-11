package com.works

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.works.activity.DashboardActivity
import com.works.activity.LoginActivity
import com.works.models.ProfileResponse
import com.works.service.JsonBulut
import com.works.utils.Client
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WelcomeActivity : AppCompatActivity() {

    lateinit var jsonBulut: JsonBulut

    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)

        jsonBulut = Client.retrofit.create(JsonBulut::class.java)
        sharedPreferences = getSharedPreferences("app_pref", MODE_PRIVATE)
        editor = sharedPreferences.edit()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        lifecycleScope.launch {
            delay(3000)
            userLoginControl()
        }

    }

    private fun userLoginControl() {
        val token = sharedPreferences.getString("token", null)
        if (token != null) {
            // service control
            val call = jsonBulut.profile("Bearer $token")
            call.enqueue(object : Callback<ProfileResponse> {
                override fun onResponse(p0: Call<ProfileResponse?>?, p1: Response<ProfileResponse?>?) {
                    if (p1!!.isSuccessful) {
                        val intent = Intent(applicationContext, DashboardActivity::class.java)
                        startActivity(intent)
                        finish()
                    }else {
                        clearShared()
                        val intent = Intent(applicationContext, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }

                override fun onFailure(p0: Call<ProfileResponse?>?, p1: Throwable?) {
                    clearShared()
                    val intent = Intent(applicationContext, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }

            })
        }else {
            clearShared()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun clearShared() {
        editor.clear()
        editor.commit()
    }

}