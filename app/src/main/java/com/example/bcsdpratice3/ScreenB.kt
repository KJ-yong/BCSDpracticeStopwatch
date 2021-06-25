package com.example.bcsdpratice3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.bcsdpratice3.databinding.ActivityScreenBBinding

class ScreenB : AppCompatActivity() {
    lateinit var binding : ActivityScreenBBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_b)
        var answerString : String = "0"
        var init : Boolean = true
        var nomial1 : String = ""
        var nomial2 : String = ""
        var operator : String = ""
        binding = DataBindingUtil.setContentView(this, R.layout.activity_screen_b)
        binding.button1.setOnClickListener {
            if(init || answerString=="0"){
                answerString = binding.button1.text.toString()
                init = false
            }
            else answerString += binding.button1.text
            binding.answer.text = answerString
        }
        binding.button2.setOnClickListener {
            if(init || answerString=="0"){
                answerString = binding.button2.text.toString()
                init = false
            }
            else answerString += binding.button2.text
            binding.answer.text = answerString
        }
        binding.button3.setOnClickListener {
            if(init || answerString=="0"){
                answerString = binding.button3.text.toString()
                init = false
            }
            else answerString += binding.button3.text
            binding.answer.text = answerString
        }
        binding.button4.setOnClickListener {
            if(init || answerString=="0"){
                answerString = binding.button4.text.toString()
                init = false
            }
            else answerString += binding.button4.text
            binding.answer.text = answerString
        }
        binding.button5.setOnClickListener {
            if(init || answerString=="0"){
                answerString = binding.button5.text.toString()
                init = false
            }
            else answerString += binding.button5.text
            binding.answer.text = answerString
        }
        binding.button6.setOnClickListener {
            if(init || answerString=="0"){
                answerString = binding.button6.text.toString()
                init = false
            }
            else answerString += binding.button6.text
            binding.answer.text = answerString
        }
        binding.button7.setOnClickListener {
            if(init || answerString=="0"){
                answerString = binding.button7.text.toString()
                init = false
            }
            else answerString += binding.button7.text
            binding.answer.text = answerString
        }
        binding.button8.setOnClickListener {
            if(init || answerString=="0"){
                answerString = binding.button8.text.toString()
                init = false
            }
            else answerString += binding.button8.text
            binding.answer.text = answerString
        }
        binding.button9.setOnClickListener {
            if(init || answerString=="0"){
                answerString = binding.button9.text.toString()
                init = false
            }
            else answerString += binding.button9.text
            binding.answer.text = answerString
        }
        binding.button0.setOnClickListener {
            if(init||answerString=="0"){
                answerString = binding.button0.text.toString()
                init = false
            }
            else answerString += binding.button0.text
            binding.answer.text = answerString
        }
        binding.buttonClear.setOnClickListener {
            answerString = ""
            nomial1 = ""
            nomial2 = ""
            operator = ""
            binding.answer.text = "0"
            binding.expression.text =""
        }
        binding.buttonPlus.setOnClickListener {
            nomial2 = ""
            if(!init){
                if(nomial1.isEmpty()){
                    nomial1 = answerString
                    answerString = ""
                }
                else{
                    nomial2 = answerString
                    nomial1 = calculate(nomial1,nomial2,operator)
                    answerString = nomial1
                    nomial2 = ""
                    binding.answer.text = answerString
                }
                init = true
            }
            operator = binding.buttonPlus.text.toString()
            binding.expression.text = nomial1 + operator
        }
        binding.buttonMinus.setOnClickListener {
            nomial2 = ""
            if(!init){
                if(nomial1.isEmpty()){
                    nomial1 = answerString
                    answerString = ""
                }
                else{
                    nomial2 = answerString
                    nomial1 = calculate(nomial1,nomial2,operator)
                    answerString = nomial1
                    nomial2 = ""
                    binding.answer.text = answerString
                }
                init = true
            }
            operator = binding.buttonMinus.text.toString()
            binding.expression.text = nomial1 + operator
        }
        binding.buttonMulti.setOnClickListener {
            nomial2 = ""
            if(!init){
                if(nomial1.isEmpty()){
                    nomial1 = answerString
                    answerString = ""
                }
                else{
                    nomial2 = answerString
                    nomial1 = calculate(nomial1,nomial2,operator)
                    answerString = nomial1
                    nomial2 = ""
                    binding.answer.text = answerString
                }
                init = true
            }
            operator = binding.buttonMulti.text.toString()
            binding.expression.text = nomial1 + operator
        }
        binding.buttonDiv.setOnClickListener {
            nomial2 = ""
            if(!init){
                if(nomial1.isEmpty()){
                    nomial1 = answerString
                    answerString = ""
                }
                else{
                    nomial2 = answerString
                    nomial1 = calculate(nomial1,nomial2,operator)
                    answerString = nomial1
                    nomial2 = ""
                    binding.answer.text = answerString
                }
                init = true
            }
            operator = binding.buttonDiv.text.toString()
            binding.expression.text = nomial1 + operator
        }
        binding.buttonEqual.setOnClickListener {
            if(init){
                if(nomial2.isEmpty()){
                    nomial2 = nomial1
                }
                binding.expression.text = nomial1 + " " + operator + " " + nomial2 + " ="
                nomial1 = calculate(nomial1,nomial2,operator)
                answerString = nomial1
            }
            else{
                if(!nomial1.isEmpty()) {
                    nomial2 = answerString
                    binding.expression.text = nomial1 + " " + operator + " " + nomial2 + " ="
                    nomial1 = calculate(nomial1, nomial2, operator)
                    answerString = nomial1
                }
            }
            init = true
            binding.answer.text = answerString
        }
    }
    fun calculate(nomial1 : String, nomial2 : String, operater : String): String {
        if(operater == "+"){
            return (nomial1.toInt() + nomial2.toInt()).toString()
        }
        else if(operater == "-"){
            return (nomial1.toInt() - nomial2.toInt()).toString()
        }
        else if(operater == "*"){
            return (nomial1.toInt() * nomial2.toInt()).toString()
        }
        else return (nomial1.toInt() / nomial2.toInt()).toString()
    }
}