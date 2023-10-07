package com.example.jjikmuk.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jjikmuk.R

data class Data(val test: String)

class RecyclerViewAdapter(private val items: ArrayList<Data>): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.textView.text = item.test
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(inflatedView)
    }

    inner class ViewHolder(v: View): RecyclerView.ViewHolder(v){
        private var view: View = v
        val textView = view.findViewById<TextView>(R.id.textView)
    }
}