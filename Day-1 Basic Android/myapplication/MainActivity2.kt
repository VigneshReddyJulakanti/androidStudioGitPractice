package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val Screen2Name=findViewById<TextView>(R.id.Screen2userName);

        val name=intent.getStringExtra("NameUser");
        Screen2Name.text="Welocome $name";
    }
}