package com.example.jjikmuk.ui.adapter


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.jjikmuk.ui.OnFragment1
import com.example.jjikmuk.ui.OnFragment2
import com.example.jjikmuk.ui.OnFragment3
import com.example.jjikmuk.ui.OnFragment4
import java.text.FieldPosition

class ViewPager2Adapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity){
    var fragments: ArrayList<Fragment> = ArrayList()
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    fun addFragment(fragment: Fragment){
        fragments.add(fragment)
        notifyItemInserted(fragments.size-1)
    }
    fun removeFragment(){
        fragments.removeLast()
        notifyItemRemoved(fragments.size)
    }
}