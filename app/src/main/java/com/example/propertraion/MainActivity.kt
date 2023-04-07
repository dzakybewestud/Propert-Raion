package com.example.propertraion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

//    private lateinit var binding: ItemViewPagerBinding
    private lateinit var introSliderViewPager: ViewPager2
    private lateinit var indicatorsContainer: LinearLayout
    private lateinit var btn_selanjutnya: MaterialButton
    private lateinit var tv_skip: TextView
    private val introSliderAdapter = IntroSliderAdapter(
        listOf(
            IntroSlide(
                "Pelatihan disesuaikan dengan Kebutuhan Kerja",
                "Kurikulum Propert menyesuaikan dengan posisi pekerjaan dan level keahlian, kamu dapat memperoleh keterampilan yang sesuai dengan tujuan karir kamu.",
                R.drawable.onboard1
            ),
            IntroSlide(
                "Pelatihan Interaktif",
                "Kamu dapat belajar dengan interaktif dengan video yang menarik, tutor yang asik dan tutor yang memberikan penjelasan yang sangat lengkap!",
                R.drawable.onboard2
            ),
            IntroSlide(
                "Belajar di mana saja dan kapan saja",
                "Kamu dapat mengakses course di mana saja dan kapan saja secara flexible!",
                R.drawable.onboard3
            )
        )
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        introSliderViewPager = findViewById(R.id.introSliderViewPager)
        introSliderViewPager.adapter = introSliderAdapter
        setupIndicators()
        setCurrentIndicator(0)

        introSliderViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback(){

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })

        btn_selanjutnya = findViewById(R.id.btn_selanjutnya)
        btn_selanjutnya.setOnClickListener {
            if (introSliderViewPager.currentItem + 1 < introSliderAdapter.itemCount) {
                introSliderViewPager.currentItem += 1
            } else {
                Intent(applicationContext, LoginActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
        tv_skip = findViewById(R.id.tv_lewati)
        tv_skip.setOnClickListener{
            Intent(applicationContext, LoginActivity::class.java).also {
                startActivity(it)
            }
        }

//        goToLogin = findViewById(R.id.button)
//
////        Intent to go to Login Page
//        goToLogin.setOnClickListener{
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//        }

    }

    private fun setupIndicators(){
        val indicators = arrayOfNulls<ImageView>(introSliderAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8,0,8,0)

        indicatorsContainer = findViewById(R.id.indicatorsContainer)
        for (i in indicators.indices){
            indicators[i] = ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
                this?.layoutParams = layoutParams
            }
            indicatorsContainer.addView(indicators[i])
        }
    }

    private fun setCurrentIndicator(index: Int){
        val childCount = indicatorsContainer.childCount
        for (i in 0 until childCount){
            val imageView = indicatorsContainer[i] as ImageView
            if (i == index){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
            }
        }
    }
}