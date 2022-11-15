package com.example.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.fragment.databinding.FragmentOneBinding

class OneFragment : Fragment() {
    var mainActivity:MainActivity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        layoutinflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOneBinding.inflate(layoutinflater, container, false)
        if(this.arguments?.getString("key")!=null){
            binding.frTv01.text =  this.arguments?.getString("key")
        }

        Log.d("fragment", "${this.arguments?.getString("key")}")


        //이벤트 설정
        binding.frIvPicture01.setOnClickListener {
            Toast.makeText(container?.context, "르누아르 그림 첫번째", Toast.LENGTH_SHORT).show()
            binding.frTv01.text = "점심식사".toString()
        }

        binding.fr01BtnSendFr02.setOnClickListener{
            mainActivity?.changeFragment( "frg02", binding.fr01EdtMessage.text.toString())
        }
        return binding.root
    }
}