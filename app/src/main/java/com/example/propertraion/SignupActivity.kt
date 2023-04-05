package com.arvan.signup

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val fullNameButton = findViewById<Button>(R.id.btn_fullname)
        val emailButton = findViewById<Button>(R.id.btn_email)
        val passwordButton = findViewById<Button>(R.id.btn_pw)
        val registerButton = findViewById<Button>(R.id.button)

        fullNameButton.setOnClickListener {
            val fullNameEditText = findViewById<EditText>(R.id.et_fullname)
            val fullName = fullNameEditText.text.toString()
            Toast.makeText(this, "Nama Lengkap: $fullName", Toast.LENGTH_SHORT).show()
        }

        emailButton.setOnClickListener {
            val emailEditText = findViewById<EditText>(R.id.et_email)
            val email = emailEditText.text.toString()
            Toast.makeText(this, "Email: $email", Toast.LENGTH_SHORT).show()
        }

        passwordButton.setOnClickListener {
            val passwordEditText = findViewById<EditText>(R.id.et_password)
            val password = passwordEditText.text.toString()
            Toast.makeText(this, "Password: $password", Toast.LENGTH_SHORT).show()
        }

        registerButton.setOnClickListener {
            val fullNameEditText = findViewById<EditText>(R.id.et_fullname)
            val emailEditText = findViewById<EditText>(R.id.et_email)
            val passwordEditText = findViewById<EditText>(R.id.et_password)
            val fullName = fullNameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (fullName.isEmpty()) {
                fullNameEditText.error = "Nama lengkap harus diisi"
                fullNameEditText.requestFocus()
                return@setOnClickListener
            }

            if (email.isEmpty()) {
                emailEditText.error = "Email harus diisi"
                emailEditText.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                passwordEditText.error = "Password harus diisi"
                passwordEditText.requestFocus()
                return@setOnClickListener
            }

            Toast.makeText(this, "Pendaftaran berhasil", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
