package com.example.hng6

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {
    override fun onCreate(savedInstancesState: Bundle?) {
        super.onCreate(savedInstancesState)
        setContentView(R.layout.activity_login)

        val login_email = findViewById<EditText>(R.id.login_email)
        val login_password = findViewById<EditText>(R.id.login_password)
        val btnlogin = findViewById<Button>(R.id.Login)

        val preferences:SharedPreferences = this.getSharedPreferences("MYPREPS", Context.MODE_PRIVATE)

        btnlogin.setOnClickListener {
            val email = login_email.text.toString()
            val password = login_password.text.toString()


            val userDetails = preferences.getString(
                email + password + "data",
                "username or password is incorrect."
            )
            val editor = preferences.edit()
            editor.putString("display", userDetails)
            editor.commit()

            val activity_scrolling = Intent(this@Login, DisplayScreen::class.java)
            startActivity(activity_scrolling)
            }


    }
}
