package com.example.jjikmuk.ui



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.jjikmuk.R
import com.example.jjikmuk.databinding.ActivityMainBinding
import com.example.jjikmuk.databinding.ActivityViewBinding
import com.example.jjikmuk.databinding.Onfragment1Binding
import com.example.jjikmuk.ui.adapter.ViewPager2Adapter
import com.example.jjikmuk.util.BaseActivity
import me.relex.circleindicator.CircleIndicator3

class ViewActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var viewPager2Adapter = ViewPager2Adapter(this)
        binding.viewPager.adapter = viewPager2Adapter
        binding.indicator.setViewPager(binding.viewPager)

        viewPager2Adapter.addFragment(OnFragment1())
        viewPager2Adapter.addFragment(OnFragment2())
        viewPager2Adapter.addFragment(OnFragment3())
        viewPager2Adapter.addFragment(OnFragment4())

        binding.viewPager.apply {
            adapter = viewPager2Adapter
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            })
        }
    }
}