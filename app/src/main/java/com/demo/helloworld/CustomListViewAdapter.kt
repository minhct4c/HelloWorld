package com.demo.helloworld

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

data class CustomListViewAdapter(private val context : Context, private val layout: Int, private val listOfOption : List<OptionListView>) : BaseAdapter() {
    override fun getCount(): Int {
        return listOfOption.size
    }

    override fun getItem(p0: Int): Any {
        return listOfOption[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var convertView : View? = p1
        val inflater : LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        if (convertView == null) {
            convertView = inflater.inflate(layout, null)
        }
        val imageIcon: ImageView = convertView!!.findViewById(R.id.optionIcon)
        val titleOption: TextView = convertView!!.findViewById(R.id.optionTitle)
        val optionNotify: ImageView = convertView!!.findViewById(R.id.optionNotify)
        val option: OptionListView = listOfOption.get(p0)
        imageIcon.setImageResource(option.icon)
        titleOption.setText(option.title)
        optionNotify.setImageResource(option.notificationPopup)
        return convertView
    }

}