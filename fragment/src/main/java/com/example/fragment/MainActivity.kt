package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Toast
import com.example.fragment.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var oneFragment: OneFragment
    lateinit var twoFragment: TwoFragment
    lateinit var threeFragment: ThreeFragment
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        oneFragment = OneFragment()
        twoFragment = TwoFragment()
        threeFragment = ThreeFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.layout_frame, oneFragment)
            .commit()

        //탭레이아웃에 메뉴를 입력
        val tab1: TabLayout.Tab = binding.tabLayout.newTab()
        tab1.text = "frg01"
        val tab2: TabLayout.Tab = binding.tabLayout.newTab()
        tab2.text = "frg02"
        val tab3: TabLayout.Tab = binding.tabLayout.newTab()
        tab3.text = "frg03"


        binding.tabLayout.addTab(tab1)
        binding.tabLayout.addTab(tab2)
        binding.tabLayout.addTab(tab3)

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.text) {
                    "frg01" -> {
                        changeFragment("frg01", null)
                    }
                    "frg02" ->{
                        supportFragmentManager.beginTransaction()
                        changeFragment("frg02",null)
                    }
                    "frg03" ->{
                        supportFragmentManager.beginTransaction()
                        changeFragment("frg03",null)
                    }
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }

    fun changeFragment(data: String, data2:String?) {
        val bundle = Bundle()
        val tabIndex: TabLayout.Tab?
        bundle.putString("key",data2)
        when (data) {
            "frg01" -> {
                //탭레이아웃 탭을 강제로 이동
                tabIndex = binding.tabLayout.getTabAt(0)
                binding.tabLayout.selectTab(tabIndex)
                //해당 프레그먼트 보여줌
                oneFragment.arguments = bundle
                supportFragmentManager.beginTransaction()
                    .replace(R.id.layout_frame, oneFragment)
                    .commit()
            }
            "frg02" ->{
                tabIndex = binding.tabLayout.getTabAt(1)
                binding.tabLayout.selectTab(tabIndex)

                twoFragment.arguments = bundle
                supportFragmentManager.beginTransaction()
                    .replace(R.id.layout_frame, twoFragment)
                    .commit()
            }
            "frg03" ->{
                tabIndex = binding.tabLayout.getTabAt(2)
                binding.tabLayout.selectTab(tabIndex)

                threeFragment.arguments = bundle
                supportFragmentManager.beginTransaction()
                    .replace(R.id.layout_frame, threeFragment)
                    .commit()
            }
        }
    }
}