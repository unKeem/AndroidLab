package com.example.androidlab

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.WindowManager
import com.example.androidlab.databinding.ActivityMain3Binding
import com.example.androidlab.databinding.DialogMemberBinding

class CustomMemberDialog(val context: Context, val activityMain3Binding: ActivityMain3Binding) {
    //사용자 다이얼로그
    val dialog = Dialog(context)
    lateinit var onDialogClickListener: OnDialogClickListener
    fun setOnClickListener(onDialogClickListener: OnDialogClickListener) {
        this.onDialogClickListener = onDialogClickListener
    }

    fun showDialog() {
        val binding = DialogMemberBinding.inflate(LayoutInflater.from(context))
        dialog.setContentView(binding.root)
        dialog.window!!.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT
        )
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()
        binding.btnCancel.setOnClickListener {
            dialog.dismiss()
        }
        binding.btnSave.setOnClickListener {
            val name = binding.edtName.text.toString()
            val age = binding.edtAge.text.toString()
            val email = binding.edtEmail.text.toString()
            val phone = binding.edtPhone.text.toString()
            val dataVO: DataVO
            if (Math.random().toInt() % 2 == 0) {
                dataVO = DataVO(name, age, email, phone, R.drawable.person01)

            } else {
                dataVO = DataVO(name, age, email, phone, R.drawable.person00)
            }
            (context as MainActivity3).refreshRecyclerView(dataVO)
            dialog.dismiss()

        }
    }

    interface OnDialogClickListener {
        fun onClick(data: DataVO)
    }

}