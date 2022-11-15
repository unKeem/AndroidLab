package com.example.customdialogmodule

import android.content.Context
import android.app.Dialog
import android.view.LayoutInflater
import android.view.WindowManager
import com.example.customdialogmodule.databinding.ActivityMainBinding
import com.example.customdialogmodule.databinding.DialogCustomBinding

class CustomDialog(val context: Context, val activityMainBinding: ActivityMainBinding) {
    //사용자 다이얼로그
    val dialog = Dialog(context)
    lateinit var onDialogClickListener: OnDialogClickListener

    fun setOnClickListener(onDialogClickListener: OnDialogClickListener) {
        this.onDialogClickListener = onDialogClickListener
    }

    fun showDialog() {
        val binding = DialogCustomBinding.inflate(LayoutInflater.from(context))
        dialog.setContentView(binding.root)
        dialog.window!!.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()
        binding.cancelButton.setOnClickListener {
            {
                dialog.dismiss()
            }
        }
        binding.finishButton.setOnClickListener {
            //정도
            onDialogClickListener.onClick(CustomData(binding.nameEdit.text.toString()))

        }
    }

    interface OnDialogClickListener {
        fun onClick(data: CustomData)
    }

}