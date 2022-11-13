package com.example.intent2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Activity2 : AppCompatActivity() {
    lateinit var receiver:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        receiver = findViewById(R.id.txtReciever)
        val valeur = intent.getStringExtra("cle")
        receiver.setText(valeur.toString())
    }
}