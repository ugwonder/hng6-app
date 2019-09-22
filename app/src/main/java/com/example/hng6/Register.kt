package com.example.hng6

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText


import androidx.appcompat.app.AppCompatActivity

class Register : AppCompatActivity() {
//    internal constructor()


    private val welcomePage:welcome_page

    init{
        welcomePage = welcome_page()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val email = findViewById<EditText>(R.id.register_email)
        val password = findViewById<EditText>(R.id.register_password)
        val full_name = findViewById<EditText>(R.id.register_full_name)
        val track = findViewById<EditText>(R.id.register_track)
        val stage = findViewById<EditText>(R.id.register_stage)
        val register = findViewById<Button>(R.id.btnregister)

        val preferences: SharedPreferences = this.getSharedPreferences("MYPREPS", Context.MODE_PRIVATE)
        register.setOnClickListener(View.OnClickListener {
            val newemail = email.text.toString()
            val newpassword = password.text.toString()
            val new_full_name = full_name.text.toString()
            val newtrack = track.text.toString()
            val newstage = stage.text.toString()



            val editor:SharedPreferences.Editor = preferences.edit()

            editor.putString(
                newemail + newpassword + "data",
                "$new_full_name/n$newtrack/n$newstage"
            )
            editor.apply()
            editor.commit()

            val activity_login = Intent(this@Register, Login::class.java)
            startActivity(activity_login)
        }) {

        }


    }
}
