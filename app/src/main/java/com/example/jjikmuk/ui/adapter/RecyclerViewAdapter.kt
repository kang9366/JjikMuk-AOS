package com.example.jjikmuk.ui.adapter

import android.graphics.Bitmap
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.jjikmuk.R

data class Data(val test: String)

class RecyclerViewAdapter(private val items: ArrayList<Data>): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.menu.text = item.test
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
        val menu = view.findViewById<TextView>(R.id.menu)
    }
}

class ImageViewModel : ViewModel() {
    val imageUri: MutableLiveData<Uri?> = MutableLiveData()
    val bitmap: MutableLiveData<Bitmap?> = MutableLiveData()
}