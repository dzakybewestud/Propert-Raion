package com.example.propertraion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private lateinit var username: EditText  //username box in login activity
    private lateinit var password: EditText  //Password box in login activity
    private lateinit var btn_login: Button //Login Button in Login Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login = findViewById(R.id.btn_masuk)
        username = findViewById(R.id.email_et)
        password = findViewById(R.id.password_et)

        btn_login.setOnClickListener {
            if (username.text.toString() == "user" && password.text.toString() == "1234"){
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}