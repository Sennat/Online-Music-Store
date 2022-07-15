package com.project.onlinemusicsearch.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.project.onlinemusicsearch.views.fragments.ClassicFragment
import com.project.onlinemusicsearch.views.fragments.PopFragment
import com.project.onlinemusicsearch.views.fragments.RockFragment

class TabsAdapter (private var fragmentManager: FragmentManager, private var lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {

        // Get a fragment from clicked position
        return when (position) {
            0 -> RockFragment()
            1 -> ClassicFragment()
            2 -> PopFragment()
            else -> RockFragment()
        }
    }
}
