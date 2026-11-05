package com.example.travel_stories

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.checkerframework.common.returnsreceiver.qual.This

class RegisterActivity : AppCompatActivity() {
    lateinit var user: EditText
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var confirm: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_register)

        user = findViewById<EditText>(R.id.name)
        email = findViewById<EditText>(R.id.email)
        password = findViewById<EditText>(R.id.password)
        confirm = findViewById<EditText>(R.id.confirmpassword)

    }

    fun startFeed(view: View) {}
    fun loginUser(view: View) {
        startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
    }
}