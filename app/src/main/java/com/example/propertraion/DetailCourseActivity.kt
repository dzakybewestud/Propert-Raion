package com.example.propertraion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DetailCourseActivity : AppCompatActivity() {

    var tabTitle = arrayOf("Tentang", "Pelajaran", "Diskusi", "Ulasan", "Sertifikat")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_course)

        var pager = findViewById<ViewPager2>(R.id.vpager2_detailcourse)
        var tabL = findViewById<TabLayout>(R.id.tabLayout_detailcourse)
        pager.adapter = DetailCourseAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tabL, pager){
            tab, position ->
                tab.text = tabTitle[position]
        }.attach()
    }
}