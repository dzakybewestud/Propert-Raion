package com.example.propertraion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.android.material.button.MaterialButton
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider

class LoginActivity : AppCompatActivity() {
    private lateinit var username: EditText  //username box in login activity
    private lateinit var password: EditText  //Password box in login activity
    private lateinit var btn_login: Button //Login Button in Login Activity
    lateinit var btn_googleLogin: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login = findViewById(R.id.btn_masuk)
        username = findViewById(R.id.et_email)
        password = findViewById(R.id.et_password)
        btn_googleLogin = findViewById(R.id.btn_googleLogin)


        btn_login.setOnClickListener {
            if (username.text.toString() == "user" && password.text.toString() == "1234"){
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}