package com.works.compose

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

class SettingsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MaterialTheme {
                SettingsScreen()
            }
        }
    }
}

@SuppressLint("ContextCastToActivity")
@Composable
fun SettingsScreen() {

    val activity = LocalContext.current as Activity

    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var nameError by remember { mutableStateOf(false) }
    var surnameError by remember { mutableStateOf(false) }
    var emailError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F6F6)),
        contentAlignment = Alignment.TopStart
    ) {



        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF6F6F6))
                .padding(16.dp),
            shape = RoundedCornerShape(20.dp)
        ) {
            // back button
            IconButton(
                onClick = {
                    activity.finish()
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }

            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {

                Text(
                    text = "Settings",
                    style = MaterialTheme.typography.headlineMedium
                )

                OutlinedTextField(
                    value = name,
                    onValueChange = {
                        name = it
                        nameError = false
                    },
                    label = { Text("Name") },
                    modifier = Modifier.fillMaxWidth(),
                    isError = nameError,
                    supportingText = {
                        if (nameError) {
                            Text("Name is required")
                        }
                    }
                )

                OutlinedTextField(
                    value = surname,
                    onValueChange = {
                        surname = it
                        surnameError = false
                    },
                    label = { Text("Surname") },
                    modifier = Modifier.fillMaxWidth(),
                    isError = surnameError,
                    supportingText = {
                        if (surnameError) {
                            Text("Surname is required")
                        }
                    }
                )

                OutlinedTextField(
                    value = email,
                    onValueChange = {
                        email = it
                        emailError = false
                    },
                    label = { Text("Email") },
                    modifier = Modifier.fillMaxWidth(),
                    isError = emailError,
                    supportingText = {
                        if (emailError) {
                            Text("Email is required")
                        }
                    }
                )

                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                        passwordError = false
                    },
                    label = { Text("Password") },
                    modifier = Modifier.fillMaxWidth(),
                    visualTransformation = PasswordVisualTransformation(),
                    isError = passwordError,
                    supportingText = {
                        if (passwordError) {
                            Text("Password is required")
                        }
                    }
                )

                Button(
                    onClick = {

                        nameError = name.isBlank()
                        surnameError = surname.isBlank()
                        emailError = email.isBlank()
                        passwordError = password.isBlank()

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Save")
                }

            }
        }
    }
}