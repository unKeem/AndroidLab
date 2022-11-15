package com.example.androidlab

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.androidlab.databinding.ActivityPhoneBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) //화면에 있는 객체를 가져오는 기능

        val binding = ActivityPhoneBinding.inflate(layoutInflater)
           setContentView(binding.root)
//
//        binding.fr1Display.setOnClickListener{
//            binding.framl01.visibility = View.VISIBLE
//            binding.framl02.visibility = View.INVISIBLE
//        }
//        binding.fr2Display.setOnClickListener{
//            binding.framl02.visibility = View.VISIBLE
//            binding.framl01.visibility = View.INVISIBLE
//        }
//        binding.fr1IvCat.setOnClickListener {
//            Toast.makeText(this,"고양이 그림을 클릭했어요", Toast.LENGTH_SHORT).show()
//        }
//        binding.fr2IvRabbit.setOnClickListener {
//            Toast.makeText(this,"토끼 그림을 클릭했어요", Toast.LENGTH_SHORT).show()
//        }
    }
}