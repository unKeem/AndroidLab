package com.example.customdialogmodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customdialogmodule.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dialog = CustomDialog(this, binding)
        binding.btnUserDialog2.setOnClickListener {
            dialog.showDialog()
        }
        dialog.setOnClickListener(object : CustomDialog.OnDialogClickListener {
            override fun onClick(customData: CustomData) {
                binding.tvMessage.text = customData.data
            }
        })
    }
}
