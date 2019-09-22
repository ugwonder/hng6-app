package com.example.hng6

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DisplayScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)

        val preferences:SharedPreferences = this.getSharedPreferences("MYPREPS", Context.MODE_PRIVATE)
        val display = preferences.getString("display", "")

        val displayInfo = findViewById<TextView>(R.id.textviewname)
        displayInfo.text = display

    }
}