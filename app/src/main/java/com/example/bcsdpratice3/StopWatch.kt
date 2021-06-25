package com.example.bcsdpratice3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.databinding.DataBindingUtil
import com.example.bcsdpratice3.databinding.ActivityStopWatchBinding
import java.util.*
import kotlin.concurrent.timer

class StopWatch : AppCompatActivity() {
    lateinit var binding : ActivityStopWatchBinding
    private var stopwatchAdapter = AdapterStopwatch(this)
    private val stopwatchRecord = mutableListOf<StopwatchData>()
    private var swTimer : Timer? = null
    private var milisec = 0
    private var sec = 0
    private var min = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_stop_watch)
        binding.rcViewRecording.adapter = stopwatchAdapter
        binding.btnStart.setOnClickListener{
            startTimer()
        }
        binding.btnStop.setOnClickListener {
            stopTimer()
            binding.textTime.text = "00:00:00"
            min=0
            sec=0
            milisec=0
            stopwatchAdapter.itemclear()
        }
        binding.btnPause.setOnClickListener {
            stopTimer()
        }
    }

    fun startTimer(){
        swTimer = timer(period = 10){
            milisec++
            if(milisec>=100){
                sec++
                milisec = 0
                if(sec>=60){
                    min++
                    sec = 0
                }
            }
            handlerStopwatch(min, sec, milisec)
            if(sec%10==0&&milisec==0){
                runOnUiThread {
                    stopwatchAdapter.addItem("10초 경과("+binding.textTime.text+")")
                }
            }
        }
    }
    private fun stopTimer(){
        swTimer?.cancel()
    }
    private fun handlerStopwatch(min:Int, sec:Int, mili:Int){
        var handlerTime : Handler = object : Handler(Looper.getMainLooper()){
            override fun handleMessage(msg: Message) {
                binding.textTime.text = intToString(min)+":"+intToString(sec)+":"+intToString(mili)
            }
        }
        handlerTime.obtainMessage().sendToTarget()
    }
    private fun intToString(num:Int):String{
        if(num>=10) return num.toString()
        else return "0"+num.toString()
    }
}