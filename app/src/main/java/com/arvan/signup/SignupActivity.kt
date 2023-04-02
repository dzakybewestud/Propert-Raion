package com.arvan.signup

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity



class SignupActivity : AppCompatActivity() {

    private lateinit var fullname: EditText
    private lateinit var email:  EditText
    private lateinit var password: EditText
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        fullname = findViewById(R.id.et_fn)
        email= findViewById(R.id.et_email)
        password = findViewById(R.id.et_password)
        registerButton = findViewById(R.id.btn_daftar)


        fullname.setOnClickListener {
            val fullNameEditText = findViewById<EditText>(R.id.et_fn)
            val fullName = fullNameEditText.text.toString()
            Toast.makeText(this, "Nama Lengkap: $fullName", Toast.LENGTH_SHORT).show()
        }

        email.setOnClickListener {
            val emailEditText = findViewById<EditText>(R.id.et_email)
            val email = emailEditText.text.toString()
            Toast.makeText(this, "Email: $email", Toast.LENGTH_SHORT).show()
        }

        password.setOnClickListener {
            val passwordEditText = findViewById<EditText>(R.id.et_password)
            val password = passwordEditText.text.toString()
            Toast.makeText(this, "Password: $password", Toast.LENGTH_SHORT).show()
        }

        registerButton.setOnClickListener {
            val fullNameEditText = findViewById<EditText>(R.id.et_fn)
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

