package com.project.onlinemusicsearch.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.tabs.TabLayoutMediator
import com.project.onlinemusicsearch.R
import com.project.onlinemusicsearch.adapters.TabsAdapter
import com.project.onlinemusicsearch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // View Binding
    private lateinit var binding: ActivityMainBinding

    // Array of "Tab" titles  and "Icons"
    private val iconArray = arrayOf(R.drawable.icon, R.drawable.icon, R.drawable.icon,)
    private val tabTitles = arrayOf("Rock", "Classic", "Pop")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getTabMediator()
    }

    private fun getTabMediator() {
        val tLayout = binding.tabLayout
        val vPager2 = binding.viewPager

        //tab.text = tabTitles[position]
        vPager2.adapter = TabsAdapter(supportFragmentManager, lifecycle)
        TabLayoutMediator(tLayout, vPager2) { tab, position ->
            //tab = tabTitles[position]
            when (position) {
                0 -> {
                    tab.apply {
                        text = tabTitles[position]
                        //text = ResourcesCompat.getColor(resources, R.color.blue_black_light, null).toString()
                        icon = ResourcesCompat.getDrawable(resources, R.drawable.ic_music_1, null)
                    }
                }
                1 -> {
                    tab.apply {
                        text = tabTitles[position]
                        //text = ResourcesCompat.getColor(resources, R.color.gray, null).toString()
                        icon = ResourcesCompat.getDrawable(resources, R.drawable.ic_music_2, null)
                    }
                }
                2 -> {
                    tab.apply {
                        text = tabTitles[position]
                        // text = ResourcesCompat.getColor(resources, R.color.fb, null).toString()
                        icon = ResourcesCompat.getDrawable(resources, R.drawable.ic_music_3, null)
                    }
                }
            }
        }.attach()
    }
}