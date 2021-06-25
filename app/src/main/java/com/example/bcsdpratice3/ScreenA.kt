package com.example.bcsdpratice3

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.adapters.TextViewBindingAdapter.setText
import com.example.bcsdpratice3.databinding.ActivityScreenBinding
import org.w3c.dom.Text

class ScreenA : AppCompatActivity() {
    lateinit var binding : ActivityScreenBinding

    val namelist = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_screen)
        val nameAdapter = ListViewAdapter(this, namelist)
        binding.buttonPlus.setOnClickListener {
            namelist.add(binding.editText.text.toString())
            binding.listView.adapter = nameAdapter
            binding.editText.setText("")
        }


    }
}