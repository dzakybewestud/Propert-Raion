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

        replaceFragment(beranda()) // default

        binding.bottomNavigationBar.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.beranda -> replaceFragment(beranda())
                R.id.mycourse -> replaceFragment(Mycourse())
                R.id.akun -> replaceFragment(akun())
                else -> { }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fragment)
            .commit()
    }
}
