package com.example.bcsdpratice3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterStopwatch(private val context : Context) : RecyclerView.Adapter<AdapterStopwatch.ViewHolder>() {

    var datas = mutableListOf<StopwatchData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.stopwatch_recycler,parent,false))
    }

    override fun getItemCount(): Int = datas.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }
    fun addItem(string : String){
        datas.add(StopwatchData(string))
        notifyDataSetChanged()
    }
    fun itemclear(){
        datas.clear()
        notifyDataSetChanged()
    }
    inner class ViewHolder(view:View) : RecyclerView.ViewHolder(view){
        private var recording : TextView = itemView.findViewById(R.id.textRecording)
        fun bind(item: StopwatchData){
            recording.text = item.recording
        }
    }
}