package com.arvan.signup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.arvan.signup.databinding.ActivityHomepageBinding

class HomePageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomepageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(Beranda()) // default

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.title) {
                "Beranda" -> replaceFragment(Beranda())
                "Pelatihan Saya" -> replaceFragment(Mycourse())
                "Akun" -> replaceFragment(Akun())
                else -> { }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.home, fragment)
            .commit()
    }
}
