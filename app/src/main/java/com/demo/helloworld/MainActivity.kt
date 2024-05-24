package com.demo.helloworld

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var listView : ListView = findViewById(R.id.listOptions)
        var listOfOptions = arrayListOf<OptionListView>()
        listOfOptions.add( OptionListView(R.drawable.calendar, "Calendar", R.drawable.blue_frame, true))
        listOfOptions.add( OptionListView(R.drawable.reward, "Rewards", R.drawable.blue_frame, true))
        listOfOptions.add( OptionListView(R.drawable.map, "Address", R.drawable.blue_frame, true))
        listOfOptions.add( OptionListView(R.drawable.wallet, "Payment Methods", R.drawable.blue_frame, true))
        listOfOptions.add( OptionListView(R.drawable.icon, "Offers", R.drawable.blue_frame, true))
        listOfOptions.add( OptionListView(R.drawable.people, "Refer a friend", R.drawable.blue_frame, true))
        listOfOptions.add( OptionListView(R.drawable.call, "Support", R.drawable.blue_frame, true))

        val customAdapter = CustomListViewAdapter(this, R.layout.list_option, listOfOptions)
        listView.adapter = customAdapter
    }
}