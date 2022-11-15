package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.fragment.databinding.FragmentOneBinding
import com.example.fragment.databinding.FragmentTwoBinding


class TwoFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        layoutinflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTwoBinding.inflate(layoutinflater, container, false)

        if(this.arguments?.getString("key")!=null){
            binding.frTv02.text =  this.arguments?.getString("key")
        }

        binding.frIvPicture02.setOnClickListener {
            Toast.makeText(container?.context, "르누아르 그림 두번째", Toast.LENGTH_SHORT).show()
            binding.frTv02.text = "시골무도회"
        }
        return binding.root
    }

}