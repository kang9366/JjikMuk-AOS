package com.example.jjikmuk.ui.mypage

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jjikmuk.R
import org.w3c.dom.Text

class CalendarAdapter(private val listener: (calendarDateModel: CalendarDateModel, position: Int) -> Unit) :
    RecyclerView.Adapter<CalendarAdapter.MyViewHolder>() {
    private val list = ArrayList<CalendarDateModel>()

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(calendarDateModel: CalendarDateModel) {
            val calendarDay = itemView.findViewById<TextView>(R.id.tv_day)
            val calendarDate = itemView.findViewById<TextView>(R.id.tv_date)
            val cardView = itemView.findViewById<CardView>(R.id.card_calendar)
            val frameLayout = itemView.findViewById<FrameLayout>(R.id.frame)

            if (calendarDateModel.isSelected) {
                calendarDate.setTextColor(
                    ContextCompat.getColor(itemView.context, R.color.white)
                )
                frameLayout.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.main_color))
            } else {
                calendarDate.setTextColor(
                    ContextCompat.getColor(itemView.context, R.color.black)
                )
                frameLayout.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.white))
            }

            val day = calendarDateModel.calendarDay
            calendarDay.text = day
            calendarDate.text = calendarDateModel.calendarDate
            cardView.setOnClickListener {
                listener.invoke(calendarDateModel, adapterPosition)
            }

            val img = itemView.findViewById<ImageView>(R.id.iv_cal_emoji)
            val stateText = itemView.findViewById<TextView>(R.id.tv_cal_state)
            when (calendarDateModel.calendarDate) {
                "1"-> {
                    img.setBackgroundResource(R.drawable.image_cal_soso)
                    stateText.text = "보통"
                }
                "2" -> {
                    img.setBackgroundResource(R.drawable.image_cal_soso)
                    stateText.text = "보통"
                }
                "3"-> {
                    img.setBackgroundResource(R.drawable.image_cal_bad)
                    stateText.text = "매우 부족"
                    stateText.setTextColor(ContextCompat.getColor(itemView.context, R.color.cal_bad))
                }
                "4"-> {
                    img.setBackgroundResource(R.drawable.image_cal_good)
                    stateText.text = "충분"
                    stateText.setTextColor(ContextCompat.getColor(itemView.context, R.color.cal_good))
                }
                "5"-> {
                    img.setBackgroundResource(R.drawable.image_cal_good)
                    stateText.text = "충분"
                    stateText.setTextColor(ContextCompat.getColor(itemView.context, R.color.cal_good))
                }
                "6" -> {
                    img.setBackgroundResource(R.drawable.image_cal_soso)
                    stateText.text = "보통"
                }
                "7" -> {
                    img.setBackgroundResource(R.drawable.image_cal_bad)
                    stateText.text = "매우 부족"
                    stateText.setTextColor(ContextCompat.getColor(itemView.context, R.color.cal_bad))
                }
                "8" -> {
                    img.setBackgroundResource(R.drawable.image_cal_good)
                    stateText.text = "충분"
                    stateText.setTextColor(ContextCompat.getColor(itemView.context, R.color.cal_good))
                }
                else -> {}
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.calendar_day_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(calendarList: ArrayList<CalendarDateModel>) {
        list.clear()
        list.addAll(calendarList)
        notifyDataSetChanged()
    }
}