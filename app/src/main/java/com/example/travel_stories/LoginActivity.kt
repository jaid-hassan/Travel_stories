package com.example.travel_stories

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class LoginActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email = findViewById<EditText>(R.id.email)
        password = findViewById<EditText>(R.id.password)

    }

    fun registerUser(view: View) {
        startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
    }

    fun startFeed(view: View) {

        var sEmail = email.text.toString()
        var sPassword = password.text.toString()

        FirebaseAuth.getInstance().signInWithEmailAndPassword(sEmail,sPassword).addOnSuccessListener { result ->
            val uid = result.user!!.uid
            val email = result.user!!.email

            FirebaseDatabase.getInstance().getReference("users").child(uid).get().addOnSuccessListener { snapshot ->
                val username = snapshot.getValue(String::class.java)
                val intent = Intent(this@LoginActivity, FeedActivity::class.java)
                intent.putExtra("Id", uid)
                intent.putExtra("Username", username)
                intent.putExtra("Email", email)
                startActivity(intent)

            }
        }
    }
}