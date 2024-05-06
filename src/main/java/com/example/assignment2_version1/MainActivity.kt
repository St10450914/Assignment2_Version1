package com.example.assignment2_version1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button_next = findViewById<Button>(R.id.btn_start)

        button_next.setOnClickListener {

            val intent = Intent(this, Second_Page::class.java)
            startActivity(intent)
        }
    }
}