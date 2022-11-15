package com.example.androidlab

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.androidlab.databinding.ItemMainBinding

class CustomAdapter (val dataList:MutableList<DataVO>, val parentContext : Context) : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>(){
    //데이터가 몇개나 있는지 알려줌
    override fun getItemCount() = dataList.size
    //customviewholder의 실체를 만든다
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding = ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(customViewHolder: CustomViewHolder, position: Int) {
        val binding = customViewHolder.binding
        val data = dataList.get(position)
        binding.ivPicture.setImageResource(data.picture)
        binding.tvName.text = data.name
        binding.tvEmail.text = data.email
        binding.tvPhone.text = data.phone

        //이벤트설정
        customViewHolder.itemView.setOnClickListener{
            Toast.makeText(parentContext, "이름: ${data.name} 전화: ${data.phone}", Toast.LENGTH_SHORT).show()

        }
        customViewHolder.itemView.setOnLongClickListener{
            val dataVO = dataList.get(position)
            (parentContext as MainActivity3).refreshRecyclerViewDrop(dataVO)
            true
        }
    }


    //내부클래스 사용자 뷰 홀더를 정의
    class CustomViewHolder(val binding: ItemMainBinding): RecyclerView.ViewHolder(binding.root)
}