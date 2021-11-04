package com.example.themoviedb.movies

import ViewPagerAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.themoviedb.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MoviesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movies_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Movies"
        val viewPagerAdapter = ViewPagerAdapter(this)
        val pager = view.findViewById<ViewPager2>(R.id.pager)
        pager.adapter = viewPagerAdapter
        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        TabLayoutMediator(
            tabLayout,
            pager
        ) { tab, position ->
            when (position) {
                0 -> tab.text = "Popular"
                1 -> tab.text = "Top Rated"
            }
        }.attach()
    }
}
