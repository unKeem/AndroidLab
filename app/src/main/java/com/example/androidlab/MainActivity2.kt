package com.example.androidlab

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidlab.databinding.ActivityResourceBinding
import com.example.androidlab.databinding.CustomMemberBinding

class MainActivity2 : AppCompatActivity() {
    var year: Int = 0
    var month: Int = 0
    var date: Int = 0
    var hour: Int = 0
    var minute: Int = 0
    lateinit var userDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityResourceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDatepicker.setOnClickListener {
            DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(datePicker: DatePicker?, y: Int, m: Int, d: Int) {
                    year = y
                    month = m
                    date = d
                    Log.d("app", "year: ${year}, month: ${month + 1}, date: ${date}")
                    binding.tvDatepicker.text = " ${year}. ${month + 1}. ${date}"
                }
            }, 2022, 9, 26).show()
        }

        binding.btnTimepicker.setOnClickListener {
            TimePickerDialog(this, object : TimePickerDialog.OnTimeSetListener {
                override fun onTimeSet(timePicker: TimePicker?, h: Int, m: Int) {
                    hour = h
                    minute = m
                    binding.tvDatepicker.text = "${hour} : ${minute}"
                }
            }, 16, 14, true).show()
        }

        binding.btnAlterdialog.setOnClickListener {
            val eventHandler = DialogInterface.OnClickListener { _, p1 ->
                when (p1) {
                    DialogInterface.BUTTON_POSITIVE -> {
                        Toast.makeText(applicationContext, "????????????", Toast.LENGTH_SHORT).show()
                    }
                    DialogInterface.BUTTON_NEGATIVE -> {
                        Toast.makeText(applicationContext, "??????????????????", Toast.LENGTH_SHORT).show()
                    }
                    else -> {
                        Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            AlertDialog.Builder(this).run {
                setTitle("????????? ??????????????? ???")
                setIcon(android.R.drawable.ic_dialog_alert)
                setMessage("?????? ?????? ??????????????????")
                setPositiveButton("OK", eventHandler)
                setNegativeButton("cancel", eventHandler)
                show()
            }
        }

        binding.btnItem.setOnClickListener {
            val items = arrayOf<String>("??????", "??????", "?????????", "?????????")
            val eventHandler = DialogInterface.OnClickListener { _, p1 ->
                when (p1) {
                    DialogInterface.BUTTON_POSITIVE -> {
                        Toast.makeText(applicationContext, "????????? ????????? ??????", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            AlertDialog.Builder(this).run {
                setTitle("????????? ??????????????? ???")
                setIcon(android.R.drawable.ic_dialog_alert)
                setItems(items, object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, index: Int) {
                        Toast.makeText(
                            applicationContext,
                            "????????? ????????? ????????? ${items[index]}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })
                setPositiveButton("??????", eventHandler)
                show()
            }
        }

        binding.btnMulticheck.setOnClickListener {
            val items = arrayOf<String>("??????", "??????", "?????????", "?????????")
            val eventHandler = DialogInterface.OnClickListener { _, p1 ->
                when (p1) {
                    DialogInterface.BUTTON_POSITIVE -> {
                        Toast.makeText(this@MainActivity2, "????????? ????????? ??????", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            AlertDialog.Builder(this).run {
                setTitle("????????????????????? ???????????????")
                setIcon(android.R.drawable.ic_dialog_alert)
                setMultiChoiceItems(
                    items,
                    booleanArrayOf(false, false, false, false),
                    object : DialogInterface.OnMultiChoiceClickListener {
                        override fun onClick(p0: DialogInterface?, index: Int, flag: Boolean) {
                            Toast.makeText(
                                applicationContext,
                                "${items[index]} ${flag}",
                                Toast.LENGTH_LONG
                            ).show()
                        }

                    })
                setPositiveButton("??????", eventHandler)
                show()
            }
        }

        binding.btnRadio.setOnClickListener {
            val items = arrayOf<String>("??????", "??????", "?????????", "?????????")
            val eventHandler = DialogInterface.OnClickListener { _, p1 ->
                when (p1) {
                    DialogInterface.BUTTON_POSITIVE -> {
                        Toast.makeText(applicationContext, "????????? ????????? ??????", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            AlertDialog.Builder(this).run {
                setTitle("???????????????????????? ???????????????")
                setIcon(android.R.drawable.ic_dialog_alert)
                setSingleChoiceItems(items, 1, object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, index: Int) {
                        Toast.makeText(
                            this@MainActivity2,
                            "${items[index]} ?????????????????????",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })
                setPositiveButton("??????", eventHandler)
                setCancelable(false) //????????? ?????? ??????
                show().setCanceledOnTouchOutside(false)// ??????????????? ??? ?????? ???????????? ???????????? ??????
            }
        }


        binding.btnUserdialog.setOnClickListener {
            //1.?????????????????????.
            val userBinding = CustomMemberBinding.inflate(layoutInflater)
            //2. ????????? ??????
            val builder = AlertDialog.Builder(this)
            //3.????????? ???????????? ??????
            builder.setTitle("??????????????? ???????????????")
            builder.setView(userBinding.root)
            //4.builder.show() =>userDialog = builder.create(), userDialog.show(), dismiss()????????? ??????
            userDialog = builder.create()
            userDialog.show()

            userBinding.btnOk.setOnClickListener {
                binding.textView3.text = userBinding.etvName.text.toString()
                userDialog?.dismiss()
            }
            userBinding.btnCancel.setOnClickListener {
                Toast.makeText(applicationContext, "?????????????????????.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}