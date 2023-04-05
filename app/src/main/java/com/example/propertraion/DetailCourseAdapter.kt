package com.example.propertraion

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class DetailCourseAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 5
    }
//tentang pelajaran diskusi ulasan sertifikat
    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return TentangFragment()
            1 -> return PelajaranFragment()
            2 -> return DiskusiFragment()
            3 -> return UlasanFragment()
            4 -> return SertifikatFragment()
            else -> return TentangFragment()
        }
    }

}