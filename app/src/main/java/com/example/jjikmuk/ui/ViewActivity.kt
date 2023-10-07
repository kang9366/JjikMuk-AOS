package com.example.jjikmuk.ui



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.jjikmuk.databinding.ActivityViewBinding

class ViewActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var viewPager2Adapter = ViewPager2Adapter(this)

        viewPager2Adapter.addFragment(OnFragment1())
        viewPager2Adapter.addFragment(OnFragment2())
        viewPager2Adapter.addFragment(OnFragment3())

        binding.viewpager.apply {
            adapter = viewPager2Adapter
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            })
        }
    }
}